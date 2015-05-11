#!/usr/bin/env python
from sys import argv

def min_path(m):
  mt = [[row[i] for row in m] for i in range(len(m))]
  last_col = mt[-1]
  for c in range(len(mt)-2,-1,-1):
    last_col = meld_cols(mt[c],last_col)
  return min(last_col)

def meld_cols(new,old):
  result = []
  for r in range(len(new)):
    sum = 0
    best = float('inf')
    for r2 in range(r,len(new)):
      sum = sum + new[r2]
      if sum + old[r2] < best:
        best = sum + old[r2]
    sum = 0
    for r2 in range(r,-1,-1):
      sum = sum + new[r2]
      if sum + old[r2] < best:
        best = sum + old[r2]
    result = result + [best]
  return result

if __name__ == '__main__':
  with open(argv[1]) as f:
    m = [map(lambda x: int(x),l.split(',')) for l in f.readlines()]
    print min_path(m)
