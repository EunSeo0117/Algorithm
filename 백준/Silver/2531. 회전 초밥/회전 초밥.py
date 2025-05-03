# 회전초밥(2531)
import sys
input = sys.stdin.readline
n, d, k, c = map(int, input().split())
li = [int(input()) for _ in range(n)]
maxnum = 0
for i in range(n):
    if i+k > n: # n보다 큰경우(맨끝과 맨앞 끝어서 붙임) + 쿠폰초밥추가) 집합이라중복제거됨
        num = len(set(li[i:n] + li[:(i+k)%n] + [c]))
    else:
        num = len(set(li[i:i+k] + [c]))
    if maxnum < num:
        maxnum = num
print(maxnum)


