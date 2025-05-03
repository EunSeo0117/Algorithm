import sys
input = sys.stdin.readline

n,m = map(int, input().split())
li = list(map(int,input().split()))

answer = 0
s, e = 0, 0
counter = [0]* (max(li)+1)
while e < n:
    if counter[li[e]] < m:
        counter[li[e]] +=1
        e +=1
    else:
        counter[li[s]] -=1
        s +=1
    answer = max(answer, e-s)
print(answer)