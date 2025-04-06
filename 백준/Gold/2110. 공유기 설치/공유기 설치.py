import sys
input = sys.stdin.readline

n,c = map(int,input().split())
home = []
for i in range(n):
    home.append(int(input()))
home.sort()

s = 1
e = home[-1] - home[0]
res = 0

while s <= e:
    mid = (s+e)//2
    current = home[0]
    count =1
    for i in range(1, len(home)):
        if home[i] >= current + mid:
            count +=1
            current = home[i]
    if count >= c:
        s = mid+1
        res = mid
    else:
        e = mid-1
print(res)
