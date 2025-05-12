import sys
input = sys.stdin.readline
k, n = map(int, input().split())
li = list(map(int,input().split()))

s = 1
e = max(li)
while s <= e:
    m = (s+e)//2
    line = 0
    for i in li:
        line += i//m
    if line >= k:
        s = m+1
    else:
        e = m-1
print(e)