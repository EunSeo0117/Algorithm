import sys
from collections import deque
n, k = map(int, input().split())
q = deque()
l = k+2 if k >= n else n
visited = [-1] * l

q.append([n,0])

while q:
    w, deph = q.popleft()
    if w == k:
        print(deph)
        result = []
        t = w
        while t != n:
            result.append(t)
            t = visited[t]
        result += [n]
        print(*result[::-1])
        break

    if w - 1 >= 0  and visited[w-1] == -1:
        visited[w-1] = w
        q.append([w-1, deph+1])
    if w + 1 < k+1 and visited[w+1] == -1:
        visited[w+1] = w
        q.append([w+1, deph+1])
    if w * 2 <= k + 1 and visited[w*2] == -1:
        visited[w*2] = w
        q.append([w*2, deph+1])