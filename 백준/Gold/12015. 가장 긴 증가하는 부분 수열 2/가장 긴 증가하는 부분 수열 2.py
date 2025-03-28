import sys
import bisect
input = sys.stdin.readline
n = int(input())
li = list(map(int,input().split()))
lis = [li[0]]
for i in li:
    if lis[-1] < i:
        lis.append(i)
    else:
        idx = bisect.bisect_left(lis,i)
        lis[idx] = i
print(len(lis))