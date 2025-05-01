from collections import deque
import sys

def bfs(x,y):
    directions = [(-1,0), (1,0), (0,-1), (0,1)]
    q = deque([(x,y)])
    count = 0

    while q:
        cx, cy = q.popleft()
        if visited[cx][cy]:
            continue

        visited[cx][cy] = True
        count +=1

        for dx,dy in directions:
            nx, ny = cx + dx , cy+dy
            if 0<=nx <n and 0 <= ny < m and not visited[nx][ny] and graph[nx][ny] == 1:
                q.append((nx, ny))

    return count


n, m = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
visited = [[False]* m for _ in range(n)]

num_pictures = 0
max_area = 0

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1 and not visited[i][j]:
            num_pictures +=1
            area = bfs(i,j)
            max_area = max(max_area, area)

print(num_pictures)
print(max_area)


