import sys
input = sys.stdin.readline
n= int(input())
date = []
for i in range(n):
    s1,s2,e1,e2 = map(int,input().split())
    s = (s1*100)+s2
    e = (e1*100)+e2
    date.append([s,e])
date.sort()
endD = 301
count = 0

while date:
    if endD >=1201 or date[0][0] > endD:
        break
    tempEnd = -1
    for _ in range(len(date)):
        if date[0][0] <= endD:
            if tempEnd <= date[0][1]:
                tempEnd =date[0][1]
            date.remove(date[0])
        else:
            break  
    
    endD = tempEnd
    count+=1  
if endD <1201:
    print(0)
else:
    print(count)
