# 1012번 유기농 배추
import sys
sys.setrecursionlimit(10000)
 
T = int(sys.stdin.readline().rstrip())
cnt = 0

def dfs(x,y):
    if x <= -1 or x >= N or y<= -1 or y >= M:
        return False
    
    if graph[x][y] == 1:
        graph[x][y] = 0
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        return True
    
    return False
    
for _ in range(T):
    M,N,K = map(int,sys.stdin.readline().rstrip().split())
    graph =[[0] * M for _ in range(N)]

    for _ in range(K):
        x, y = map(int, sys.stdin.readline().rstrip().split())
        graph[y][x] = 1

    for i in range(N):
        for j in range(M):
            if dfs(i,j) == True:
                cnt +=1

    print(cnt)
    cnt = 0
