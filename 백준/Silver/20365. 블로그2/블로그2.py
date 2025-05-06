import sys
input = sys.stdin.readline
n = int(input())
s = input()
answer = 1
m = s[0]
for i in range(1,len(s)):
    if s[i] == m:
        continue
    else: # 다를때
        if s[i-1] == s[i]:
            continue
        else:
            answer+=1
print(answer-1) 