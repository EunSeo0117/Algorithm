import sys
from collections import defaultdict

input = sys.stdin.readline
m, n = map(int,input().split())
d = defaultdict(int)
for _ in range(m):
    u1 = list(map(int,input().split())) # 321
    sortu1 = sorted(list(set(u1))) # 123
    rank = {sortu1[i] : i for i in range(len(sortu1))} # 1:0, 2:1, 3:2
    vector = tuple([rank[i] for i in u1]) # rank[3] rank[2]=3  rank[1]=2 rank[0]=1
    d[vector] += 1
sum = 0
for i in d.values():
    sum += (i*(i-1)) //2
print(sum)