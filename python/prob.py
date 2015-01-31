#!/usr/bin/python
#
# usage: ./prob.py NdD
#  N: number of dice to roll
#  M: number of sides per die
#
import sys
import re
import math
import itertools
from collections import Counter

def prob(n=1, d=6):
    return Counter([sum(p) for p in itertools.product(range(1, d+1), repeat=n)])

def main():
    # n rolls of d-sided di(c)e
    m = re.match('(\d+)d(\d+)', sys.argv[1])
    n = int(m.group(1))
    d = int(m.group(2))

    poss = math.pow(d, n)

    total = 0
    for r, v in sorted(prob(n, d).items()):
        print '{0}: {1}/{2} ({3})'.format(r, v, poss, float(v)/float(poss))
        total += float(v)/float(poss)

    print 'total: {0}'.format(total)

if __name__ == "__main__": main()
