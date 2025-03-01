import sys
from collections import deque


N, M = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N+1)] # [B]를 신뢰하는 목록 [1,2,3]
max_search = [-1]*(N+1) # 메모이제이션


for _ in range(M):
    A,B = map(int, sys.stdin.readline().split())
    graph[B].append(A)

def bfs(x):
    q = deque([x])
    vistied = [False]*(N+1)
    vistied[x] = True
    count = 1
    while q:
        current = q.popleft()
        for val in graph[current]:
            if not vistied[val]:
                q.append(val)
                vistied[val] = True
                count +=1
    return count

max_count = 1
result = []

for i in range(1, N+1):
    count = bfs(i)
    if count > max_count:
        max_count = count
        result = [i]
    elif count == max_count:
        result.append(i)

print(*result)
