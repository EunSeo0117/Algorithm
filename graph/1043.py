import sys
from collections import deque, defaultdict
input = sys.stdin.readline

N,M = map(int,input().split())

# 진실을 아는사람
temp = list(map(int,input().split()))
t_member = set(temp[1:]) # 진실을 아는사람의 목록


# 파티목록
parties = []
for i in range(M):
    party = list(map(int,input().split()))[1:]
    parties.append(party)

#print(*parties)


# 파티참여자들 끼리의 교류간선 연결
graph = defaultdict(set)
for party in parties:
    for mem1 in range(len(party)):
        for mem2 in range(mem1+1, len(party)):
            graph[party[mem1]].add(party[mem2])
            graph[party[mem2]].add(party[mem1])

#print(graph)

dont_connect = set()


def bfs(x):
    q=deque([x])
    dont_connect.add(x)
    visited[x] = True
    while q:
        current = q.popleft()
        for val in graph[current]:
            if visited[val] == False:
                q.append(val)
                dont_connect.add(val)
                visited[val] = True



for i in t_member:
    visited = [False]*(N+1)
    bfs(i)

count = 0
for party in parties:
    if all(person not in dont_connect for person in party):
        count+=1

print(count)
