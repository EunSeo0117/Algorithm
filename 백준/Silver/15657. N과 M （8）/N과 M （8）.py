n, m = map(int, input().split())
li = list(map(int, input().split()))
li.sort()
ans = []
def dfs(i):
    if len(ans) == m:
        print(*ans)
        return
    for j in range(i,n):
            ans.append(li[j])
            dfs(j)
            ans.pop()
dfs(0) 