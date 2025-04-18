import sys
input = sys.stdin.readline
n = int(input())
li = []
for i in range(n):
    start, end = map(int,input().split())
    li.append([start, end])

li.sort()
startPoint = li[0][0]
endPoint = li[0][1]
answer = 0
for i in range(1, len(li)):
    if endPoint >= li[i][0] and endPoint < li[i][1]:
        endPoint = li[i][1]
    elif endPoint < li[i][0]:
        answer += endPoint-startPoint
        startPoint = li[i][0]
        endPoint = li[i][1]
answer += endPoint-startPoint
print(answer)