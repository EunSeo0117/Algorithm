import sys
input = sys.stdin.readline
k, n = map(int,input().split())
line = []
for i in range(k):
    line.append(int(input()))

s = 1
e = max(line)
while s <=e:
    m = (s+e)//2
    lan = 0
    for i in line:
        lan += i//m
    if lan >= n:
        s = m+1
    else:
        e = m-1
print(e)