import sys
input = sys.stdin.readline

n = int(input())
li = list(map(int,input().split()))

s = 0
e = n-1
ans = abs(li[s]+li[e])
left = s
right = e

while s < e:
    tmp = li[s] + li[e]
    if abs(tmp) < ans:
        ans = abs(tmp)
        left = s
        right = e
    
    if ans == 0:
        break
    
    if tmp < 0:
        s +=1
    else:
        e -=1
print(li[left]+ li[right])