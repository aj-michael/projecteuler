#!/usr/bin/env python
from itertools import groupby

triangle = lambda n: n*(n+1)/2
square = lambda n: n*n
pentagon = lambda n: n*(3*n-1)/2
hexagon = lambda n: n*(2*n-1)
heptagon = lambda n: n*(5*n-3)/2
octagon = lambda n: n*(3*n-2)


def polygonal(f,a,b):
  ls = []
  for n in range(1,b):
    p = f(n)
    if p >= b:
      return ls
    elif p >= a:
      ls = ls + [p]

def cyclic(ls):
  ls = map(transform,ls)
  first = ls.pop(0)
  for _ in range(1,6):
    second = ls.pop(0)
    if first[1] == second[0]:
      for _ in range(1,5):
        third = ls.pop(0)
        if second[1] == third[0]:
          for _ in range(1,4):
            fourth = ls.pop(0)
            if third[1] == fourth[0]:
              for _ in range(1,3):
                fifth = ls.pop(0)
                sixth = ls.pop(0)
                if fourth[1] == fifth[0] and fifth[1] == sixth[0] and sixth[1] == first[0]:
                  return True
                ls.append(sixth)
                ls.append(fifth)
            ls.append(fourth)
        ls.append(third)
    ls.append(second)
  return False

def transform(n):
  return [str(n)[:2],str(n)[2:]]

def fourcheck(ls):
  a = [a for b in map(transform,ls) for a in b]
  duplist = [len(list(group)) for _, group in groupby(a)]
  return duplist.count(1) <= 4

def fivecheck(ls):
  a = [a for b in map(transform,ls) for a in b]
  duplist = [len(list(group)) for _, group in groupby(a)]
  return duplist.count(1) <= 2
 
def sixcheck(ls): 
  a = [a for b in map(transform,ls) for a in b]
  duplist = [len(list(group)) for _, group in groupby(a)]
  return duplist.count(1) == 0

if __name__ == '__main__':
  l6 = polygonal(triangle,1000,10000)
  l5 = polygonal(square,1000,10000)
  l4 = polygonal(pentagon,1000,10000)
  l3 = polygonal(hexagon,1000,10000)
  l2 = polygonal(heptagon,1000,10000)
  l1 = polygonal(octagon,1000,10000)
  count = 0
  for a in l1:
    print str(count) + ' / ' + str(len(l1))
    count = count + 1
    for b in l2:
      for c in l3:
        for d in l4:
          if fourcheck([a,b,c,d]):
            for e in l5:
              if fivecheck([a,b,c,d,e]):
                for f in l6:
                  res = sixcheck([a,b,c,d,e,f])
                  print str(res) + str([a,b,c,d,e,f])
                  if res:
                    print a,b,c,d,e,f
