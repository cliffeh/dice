#ifndef __DICE_H
#define __DICE_H 1

int roll();
int roll(int n); // default: d6
int roll(int n, int s); // nDs
int roll(int n, int s, int m); // nDs+m

#endif
