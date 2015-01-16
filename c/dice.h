#ifndef __DICE_H
#define __DICE_H 1

int roll();
int roll_n(int n); // default: d6
int roll_ns(int n, int s); // nDs
int roll_ns_m(int n, int s, int m); // nDs+m

#endif
