import sys
n = int(input())
li = []
for i in range(n):
    start, end = map(int,sys.stdin.readline().rstrip().split())
    li.append([start,end])
li.sort(key=lambda x:(x[1], x[0]))
endP = 0
answer = 0
for newS, newE in li:
    if endP <= newS:
        answer+=1
        endP = newE
print(answer)