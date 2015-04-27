#!/usr/bin/env python
from sys import argv

memo = {}
def maxpath(m,r,c,maxr,maxc):
  if (r,c) == (maxr-1,maxc-1):
    return m[r][c]
  if r >= maxr or c >= maxc:
    return 'inf'
  if (r,c) not in memo:
    memo[r,c] = m[r][c] + min(maxpath(m,r+1,c,maxr,maxc),maxpath(m,r,c+1,maxr,maxc))
  return memo[r,c]

if __name__ == '__main__':
  with open(argv[1]) as f:
    m = [map(lambda x: int(x),l.split(',')) for l in f.readlines()]
    print maxpath(m,0,0,len(m),len(m[0]))
