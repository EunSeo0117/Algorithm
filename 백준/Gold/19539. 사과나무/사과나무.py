import sys
input = sys.stdin.readline
n = int(input())
li = list(map(int, input().split()))
a, b = 0,0
for i in range(n):
    a += li[i] // 2
    b += li[i] % 2
if a>= b and (a - b) % 3 == 0:
    print("YES")
else:
    print("NO")