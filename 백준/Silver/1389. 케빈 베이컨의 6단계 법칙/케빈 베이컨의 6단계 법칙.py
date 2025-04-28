import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]

for _ in range(M):
    A,B = map(int, input().split())
    if B not in graph[A]:
        graph[A].append(B)
    if A not in graph[A]:
        graph[B].append(A)

result = [-1]*(N+1) # 각 유저별 총베이컨 수

def bfs(x):
    q = deque([x])
    visited[x] = True
    temp[x] = 0
    while q:
        current = q.popleft()
        for val in graph[current]:
            if visited[val] == False:
                q.append(val)
                visited[val] = True
                temp[val] = temp[current]+1
    
    return sum(temp)

for i in range(1,N+1):
    visited = [False]*(N+1)
    temp = [0]*(N+1)
    result[i] = (bfs(i))

minIdx = 5001
minNum = 5001

for i in range(1, N+1):
    if result[i] < minNum:
        minNum = result[i]
        minIdx = i


print(minIdx)