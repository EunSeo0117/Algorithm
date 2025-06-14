
from sys import stdin
n = int(input())
tops = list(map(int, stdin.readline().split()))
answer = [0]*n # 0 0 2 2 4
stack=[]
for i in range(len(tops)): #
    while stack:
        if tops[stack[-1][0]]<tops[i]:
            stack.pop()
        else:
            answer[i] = stack[-1][0]+1
            break
    stack.append((i,tops[i])) # (0,6) (1,9) (2,5) (3,7) (4,4)
print(*answer)