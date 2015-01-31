#!/usr/bin/python
#
# usage: ./prob.py NdD
#  N: number of dice to roll
#  M: number of sides per die
#
import sys
import re
import itertools

# n rolls of d-sided di(c)e
m = re.match('(\d+)d(\d+)', sys.argv[1])
n = int(m.group(1))
d = int(m.group(2))

num = 0
rolls = {}
for r in [sum(p) for p in itertools.product(range(1, d+1), repeat=n)]:
    num += 1
    if r in rolls:
        rolls[r] += 1
    else:
        rolls[r] = 1

for r, v in sorted(rolls.items()):
    print '{0}: {1}/{2} ({3})'.format(r, v, num, float(v)/float(num))
