#!/usr/bin/env python

from __future__ import print_function

import random
import sys
import re

def roll(n=1, d=6):
    result = []
    for i in range(1, n+1):
        result.append(random.randint(1, d))
    return result

def main():
    n = 1
    d = 6
    for arg in sys.argv[1:]:
        try:
            n, d = arg.split('d')
        except:
            print('warning: invalid argument: {0}; using default (1d6)'.format(arg), file=sys.stderr)

    print(format(roll(int(n), int(d))))

if __name__ == '__main__': main()
