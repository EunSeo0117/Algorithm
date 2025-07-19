import sys
from collections import deque

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

graph = [[]for _ in range(n+1)]
visited = [False]*(n+1)
min_dist = [-1]*(n+1)
result = []

for _ in range(m):
    a,b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a) # 필요한가? 1,5 없이 5,1이라고 되면안되니깐

def bfs(x):
    q = deque([x])
    min_dist[x] = 0
    visited[x] = True
    while q:
        current = q.popleft()
        for val in graph[current]:
            if min_dist[current]+1 >=3:
                break

            if visited[val] == False:
                q.append(val)
                min_dist[val] = min_dist[current]+1
                visited[val] = True
                result.append(val)
            

bfs(1)
print(len(result))
