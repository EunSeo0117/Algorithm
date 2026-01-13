n, m = map(int, input().split())
li = list(map(int, input().split()))
li.sort()
ans = []
def dfs():
    if len(ans) == m:
        print(*ans)
        return
    for j in range(n):
        if li[j] not in ans:
            ans.append(li[j])
            dfs()
            ans.pop()
dfs() 