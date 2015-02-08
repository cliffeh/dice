#!/usr/bin/env python

import dice
from prob import prob

from collections import Counter

iter = 100000
thresh = .02

# {iter}d6
expected = [(1.0/6.0)*iter for r in range(0, 6)]
observed = Counter(dice.roll(iter, 6))

for i in range(0, 6):
    diff = abs(expected[i] - observed.get(i+1, 0))
    print 'expected: {0}, observed: {1}; diff: {2} ({3}%)'.format(expected[i], observed.get(i+1, 0), diff, (diff/expected[i])*100)
    if (diff/expected[i]) > thresh:
        print 'diff outside of threshold ({0}%); test failed, exiting'.format(thresh*100)
        exit(1)
