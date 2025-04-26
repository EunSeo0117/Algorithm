# 경로찾기
import sys

input = sys.stdin.readline

N = int(input())
graph = [[] for _ in range(N)]

for i in range(N):
    temp = list(map(int, input().split()))
    graph[i]=temp

#visited = [[False]*N for _ in range(N)]
result = [[0]*N for _ in range(N)]

def dfs(gindx,x): # 0,2
    #result[gindx][x]=1
    #visited[x]=True
    for i,val in enumerate(graph[x]):
        if val == 0:
            continue
        if visited[i]==True:
            continue

        result[gindx][i]=1
        visited[i] = True
        dfs(gindx,i)
            
for i in range(N):
    visited=[False]*N
    dfs(i,i)

for i in range(N):
    print(*result[i])

