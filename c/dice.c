#include "dice.h"

#include <time.h>
#include <stdlib.h>

int roll()
{
  return rollndm(1, 6, 0);
}

int rolln(int n)
{
  return rollndm(n, 6, 0);
}

int rollnd(int n, int d)
{
  return rollndm(n, d, 0);
}

int rollndm(int n, int d, int m)
{
  // TODO impl
}

