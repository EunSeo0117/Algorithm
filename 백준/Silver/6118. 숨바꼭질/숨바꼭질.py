import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int,input().split()) # 헛간갯수, 간선갯수, 1부터 숫자세기
graph = [[] for _ in range(N+1)]
for _ in range(M):
    A,B = map(int,input().split())
    graph[A].append(B)
    graph[B].append(A) # 양방향 필요?

visited = [False]*(N+1)
dist = [-1]*(N+1)

def bfs(x): 
    q = deque([x])
    visited[x] = True
    dist[x] = 0
    while q:
        current = q.popleft()
        for val in graph[current]:
            if visited[val]==False:
                q.append(val)
                visited[val] = True
                dist[val] = dist[current]+1

bfs(1)

num, num_dist, same = 0,0,1
for i, val in enumerate(dist):
    if i==0:
        continue
    if val>num_dist:
        num = i
        num_dist = val
        same = 1
    elif val==num_dist:
        same +=1
    
    
    
print(num, num_dist, same)
# 메모이제이션 사용
# bfs사용