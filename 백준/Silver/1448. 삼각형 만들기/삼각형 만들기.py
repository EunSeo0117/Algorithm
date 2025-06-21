import sys
input = sys.stdin.readline
n = int(input())
li = []
for i in range(n):
    li.append(int(input()))
li.sort()
a = li.pop()
b = li.pop()
c = li.pop()

while True:
    if a+b > c and a+c > b and b+c > a:
        print(a+b+c)
        break
    else:
        if len(li)==0:
            print(-1)
            break
        if a+b <= c:
            c = li.pop()
        elif a+c <= b:
            b = li.pop()
        elif b+c <= a:
            a = li.pop()