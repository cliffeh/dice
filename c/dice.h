#ifndef __DICE_H
#define __DICE_H 1

int roll();                       // default: 1d6
int rolln(int n);                 // default: nd6
int rollnd(int n, int d);
int rollndm(int n, int s, int m);

#endif

