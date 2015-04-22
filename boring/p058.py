#!/usr/bin/env python
from __future__ import division
from math import sqrt
from itertools import count, islice

def isPrime(n):
    if n < 2:
        return false
    return all(n%i for i in islice(count(2), int(sqrt(n)-1)))


x = 1
total = 1
prime = 0
s = 0
for s in range(26241):
    x = x + 2 * (s + 1)
    if isPrime(x):
        prime = prime + 1
    x = x + 2 * (s + 1)
    if isPrime(x):
        prime = prime + 1
    x = x + 2 * (s + 1)
    if isPrime(x):
        prime = prime + 1
    x = x + 2 * (s + 1)
    if isPrime(x):
        prime = prime + 1
    length = 2 * s + 3
    total = total + 4
    ratio = prime / total
    print 'length = ' + str(length)
    print 'ratio = ' + str(ratio)
