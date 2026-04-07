n, m = map(int, input().split())
li = []
def dfs(i):
    if len(li) == m:
        print(*li)
        return
    for j in range(i,n+1):
            li.append(j)
            dfs(j)
            li.pop()
dfs(1) 
