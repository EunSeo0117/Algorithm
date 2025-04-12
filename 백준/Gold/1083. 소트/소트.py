import sys
input = sys.stdin.readline

def max_n(inner_idx):
    tmp, idx = li[inner_idx], inner_idx
    for i in range(inner_idx+1, min(n,inner_idx+count + 1)):
        if li[i] > tmp:
            tmp = li[i]
            idx = i
    return tmp, idx

n = int(input())
li = list(map(int,input().split()))
count = int(input())
for i in range(n - 1):
    max_num, max_idx = max_n(i)
    if max_idx != i:
        del li[max_idx]
        li.insert(i, max_num)
        count -= (max_idx - i)
print(*li)
    