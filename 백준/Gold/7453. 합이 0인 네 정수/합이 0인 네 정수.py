import sys
input =sys.stdin.readline

n = int(input())
li = [list(map(int,input().split())) for _ in range(n)]
ab, cd = [],[]
for i in range(n):
    for j in range(n):
        ab.append(li[i][0]+li[j][1])
        cd.append(li[i][2]+li[j][3])
ab.sort()
cd.sort()
s = 0 # ab의 시작점
e = len(cd)-1 # cd의 끝점
res = 0
while s < len(ab) and e >= 0:
    if ab[s] + cd[e] == 0:
        nexts, nexte = s+1, e-1
        while nexts < len(ab) and ab[s]== ab[nexts]:
            nexts +=1
        while nexte >= 0 and cd[e] ==cd[nexte]:
            nexte -=1
        res += (nexts-s) * (e - nexte)
        s,e = nexts, nexte
    elif ab[s] + cd[e] > 0:
        e -=1
    else:
        s +=1
print(res)
