#include "dice.h"

#include <time.h>
#include <stdlib.h>

void roll(int *r)
{
  rollndm(r, 1, 6, 0);
}

void rolln(int *r, int n)
{
  rollndm(r, n, 6, 0);
}

void rollnd(int *r, int n, int d)
{
  rollndm(r, n, d, 0);
}

void rollndm(int *r, int n, int d, int m)
{
  // TODO impl
}

