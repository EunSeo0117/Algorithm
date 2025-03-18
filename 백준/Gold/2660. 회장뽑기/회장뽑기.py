# 회장뽑기(2660)
import sys
from collections import deque

input = sys.stdin.readline

M = int(input()) # 회원수(50미만)
graph = [[] for _ in range(M+1)]

while True:
    A, B = map(int, input().split())
    if A==-1 and B==-1:
        break
    if A in graph[B] or B in graph[A]:
        continue
    graph[A].append(B)
    graph[B].append(A)


def bfs(x):
    q = deque([x])
    visited[x] = True
    temp[x] = 0
    
    while q:
        current = q.popleft()
        for val in graph[current]:
            if visited[val] == False:
                visited[val] = True
                q.append(val)
                temp[val] = temp[current]+1
                
        
    return max(temp)


result = [-1]*(M+1)

min_score = 9999
repo = []
for i in range(1,M+1):
    visited = [False]*(M+1)
    temp = [-1]*(M+1) 
    result[i] = bfs(i)
    if min_score > result[i]:
        min_score = result[i]
        repo = [i]
    elif min_score == result[i]:
        repo.append(i)

print(min_score, len(repo))
print(*repo)