
import sys
sys.setrecursionlimit(10**6)

def dfs(x,y):
    # 위치가 w,h를 넘었거나, 이미 방문한곳은 지나치기
    if x>=W or y>=H or x<0 or y<0:
        return

    if visited[y][x] == True:
        return

    visited[y][x] = True
    #print(y,x,"방문")

    # 바다면 방문만하고 종료
    if node[y][x]==0:
        return

    # 땅이면
    # 아래, 대각선, 왼쪽 이동(재귀호출)
    if node[y][x] == 1:
        dfs(x, y+1)  # 상
        dfs(x, y-1)   # 하
        dfs(x+1, y)    # 좌
        dfs(x-1, y)   # 우
        dfs(x-1, y+1)    # 왼쪽 대각선 아래
        dfs(x-1, y-1)    # 왼쪽 대각선 위
        dfs(x+1, y+1) # 오른쪽 대각선 아래
        dfs(x+1, y-1) # 오른쪽 대각선 위


while True:
    W, H = map(int, sys.stdin.readline().split())

    if W==0 and H==0:
        break

    # 실제노드
    node = [ list(map(int,sys.stdin.readline().split())) for _ in range(H)]
    # 방문노드
    visited = [[False]*W for _ in range(H)]


    count = 0
    # 전체 블록 for문으로 순회
    for i in range(H):
        for j in range(W):

            # 방문헀으면 지나침
            if visited[i][j]:
                continue

            if node[i][j]==1: # j는 가로, i는 세로
                # dfs(j, i+1)  # 상
                # dfs(j, i-1)   # 하
                # dfs(j+1, i)    # 좌
                # dfs(j-1, i)   # 우
                # dfs(j-1, i+1)    # 왼쪽 대각선 아래
                # dfs(j-1, i-1)    # 왼쪽 대각선 위
                # dfs(j+1, i+1) # 오른쪽 대각선 아래
                # dfs(j+1, i-1) # 오른쪽 대각선 위
                dfs(j,i)
                count +=1
                #print(i,j,"번쨰 count증가")

            # 방문했으니까 True로 변경
            visited[i][j] = True
            #print(i,j,'방문')

    # 섬갯수 출력
    print(count)