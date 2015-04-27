#!/usr/bin/env python
from __future__ import division
from sys import argv

def listfracs(n):
  ls = []
  lower = Frac(2,5)
  upper = Frac(3,7)
  for d in range(n,1,-1):
    for n in range(1,d):
      f = Frac(n,d)
      if lower < f and f < upper:
        lower = f
        print 'New: ' + str(lower)
  print 'Final: ' + str(lower)

class Frac:
  def __init__(self, n, d):
    self.n = n
    self.d = d
    self.v = n / d

  def __gt__(self, other):
    return self.v > other.v

  def __str__(self):
    return "Frac("+str(self.n)+"/"+str(self.d)+")"

  def __repr__(self):
    return self.__str__()

if __name__ == '__main__':
  listfracs(int(argv[1]))
