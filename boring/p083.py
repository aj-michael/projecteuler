#!/usr/bin/env python
from sys import argv
from Queue import PriorityQueue

def min_path_old(m):
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

def min_path(m):
  maxr = len(m)
  maxc = len(m[0])
  memo = {}
  q = PriorityQueue()
  q.put((m[0][0],0,0))
  while not q.empty():
    val,r,c = q.get()
    a,b = r+1,c
    if in_bounds(a,b,maxr,maxc) and ((a,b) not in memo or val+m[a][b] < memo[a,b]):
      memo[a,b] = val+m[a][b]
      q.put((memo[a,b],a,b))
    a,b = r-1,c
    if in_bounds(a,b,maxr,maxc) and ((a,b) not in memo or val+m[a][b] < memo[a,b]):
      memo[a,b] = val+m[a][b]
      q.put((memo[a,b],a,b))
    a,b = r,c+1
    if in_bounds(a,b,maxr,maxc) and ((a,b) not in memo or val+m[a][b] < memo[a,b]):
      memo[a,b] = val+m[a][b]
      q.put((memo[a,b],a,b))
    a,b = r,c-1
    if in_bounds(a,b,maxr,maxc) and ((a,b) not in memo or val+m[a][b] < memo[a,b]):
      memo[a,b] = val+m[a][b]
      q.put((memo[a,b],a,b))
  return memo[maxr-1,maxc-1]

def in_bounds(r,c,maxr,maxc):
  res = r >= 0 and r < maxr and c >= 0 and c < maxc
  return res

if __name__ == '__main__':
  with open(argv[1]) as f:
    m = [map(lambda x: int(x),l.split(',')) for l in f.readlines()]
    print min_path(m)
