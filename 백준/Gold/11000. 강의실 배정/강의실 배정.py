import sys
import heapq
input = sys.stdin.readline
n = int(input())
li = []
for i in range(n):
    start, end = map(int,input().split())
    li.append([start, end])
li.sort()
pq = list()
heapq.heappush(pq, li[0][1]) # 첫종료시간
for i in range(1,n):
    if li[i][0] >= pq[0]: # 다음강의 시작 >= 이전강의 종료
        heapq.heappop(pq)
    heapq.heappush(pq, li[i][1])
print(len(pq))
