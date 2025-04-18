#2024.05.10
# 수 묶기(1744)
import sys
input = sys.stdin.readline
n = int(input())
plus=[]
minus=[]
flag = 0
for i in range(n):
    k = int(input())
    if k<0:
        minus.append(k)
    elif k>0:
        plus.append(k)
    elif k==0:
        flag = 1
plus.sort()
minus.sort()
answer =0
for i in range(len(plus)//2):
    a = plus.pop()
    b = plus.pop()
    if b==1:
        answer+=(a+b)
    else:
        answer +=(a*b)
if len(plus) != 0:
    answer += plus.pop()

for i in range(len(minus)//2):
    a = minus.pop(0)
    b = minus.pop(0)
    answer +=(a*b)
if len(minus) != 0:
    if flag==1:
        a = minus.pop()
        answer += a*0
    else:
        answer += minus.pop()
print(answer)
