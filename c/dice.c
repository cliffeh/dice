#include "dice.h"

#include <time.h>
#include <stdlib.h>

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
  srand(time(NULL));
  for(i = 0; i < n; i++) {
    r[i] = (rand()%d)+1;
  }
}
