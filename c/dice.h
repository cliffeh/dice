#ifndef __DICE_H
#define __DICE_H 1

void roll(int *r);                         // default: 1d6
void rolln(int *r, int n);                 // default: nd6
void rollnd(int *r, int n, int d);
void rollndm(int *r, int n, int s, int m);

#endif

