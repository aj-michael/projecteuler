#!/usr/bin/env python
from __future__ import division
from sys import argv

def countfracs(n):
  count = 0
  lower = Frac(1,3)
  upper = Frac(1,2)
  for d in range(0,n+1):
    for n in range(1,d):
      f = Frac(n,d)
      if lower < f and f < upper and gcd(n,d) == 1:
        count = count + 1
  return count
        

def gcd(a,b):
  if b == 0:
    return a
  else:
    return gcd(b,a%b)

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

  def __eq__(self, other):
    return self.n * other.d == self.d * other.n

  def __ne__(self, other):
    return not self.__eq__(other)

if __name__ == '__main__':
  print countfracs(int(argv[1]))
