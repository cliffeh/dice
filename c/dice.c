#include <stdio.h>
#include <unistd.h>
#include "dice.h"

#include <time.h>
#include <stdlib.h>

static unsigned int __dice_init = 0;

static void _dice_init(const char *filename)
{
  FILE *fp = fopen(filename, "rb");
  fread(&__dice_init, sizeof(int), 1, fp);
  fclose(fp);
#ifdef DEBUG
  fprintf(stderr, "seed: %i\n", __dice_init);
#endif
  srand(__dice_init);
}

#define DEBUG 1

static void dice_init()
{
  if(__dice_init != 0) return;
  if(access("/dev/urandom", F_OK) != -1) {
#ifdef DEBUG
    fprintf(stderr, "using /dev/urandom for seed\n");
#endif
    _dice_init("/dev/urandom");
  } else if(access("/dev/random", F_OK) != -1) {
#ifdef DEBUG
    fprintf(stderr, "using /dev/random for seed\n");
#endif
    _dice_init("/dev/urandom");
  } else {
#ifdef DEBUG
    fprintf(stderr, "using time(NULL) for seed\n");
#endif
    // fall back to time(NULL)
    srand(__dice_init=time(NULL));
  }
}

void roll(int *r)
{
  rollnd(r, 1, 6);
}

void rolln(int *r, int n)
{
  rollnd(r, n, 6);
}

void rollnd(int *r, int n, int d)
{
  int i;
  dice_init();
  for(i = 0; i < n; i++) {
    r[i] = (rand()%d)+1;
  }
}
