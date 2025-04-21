import sys
from collections import deque
def bfs(v):
    q = deque([v])
    while q:
        v =q.popleft()
        if v==k:
            return array[v]
        for next_v in (v-1, v+1, 2*v):
            if 0<= next_v < Max and not array[next_v]:
                array[next_v] = array[v] +1
                q.append(next_v)
Max = 100001
n, k = map(int, input().split())
array = [0] * Max
print(bfs(n))
    