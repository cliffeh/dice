#include <stdlib.h>
#include <stdio.h>
#include "dice.h"

#define USAGE "usage: %s N[dD]"

void fatal(char *arg) {
  fprintf(stderr, USAGE "\n", arg);
  exit(1);
}

int main(int argc, char *argv[])
{
  char *p;
  int i, n = 0, d = 0;

  if(argc != 2) fatal(argv[0]);
  
  for(p = argv[1]; *p != 0 && *p >= '0' && *p <= '9'; p++) {
    n *= 10;
    n += (*p-'0');
  }
  if(n == 0) fatal(argv[0]);

  if(*p == 'd') {
    for(p = p+1; *p != 0 && *p >= '0' && *p <= '9'; p++) {
      d *= 10;
      d += (*p-'0');
    }
    if(*p != 0) fatal(argv[0]);
  } else if (*p != 0) {
    fatal(argv[0]);
  } else {
    d = 6;
  }

  int *rolls = calloc(n, sizeof(int));
  rollnd(rolls, n, d);

  fprintf(stdout, "[%i", rolls[0]);
  for(i = 1; i < n; i++) {
    fprintf(stdout, ",%i", rolls[i]);
  }
  fprintf(stdout, "]\n");
}
