import sys
input = sys.stdin.readline

def binarySearch(target, start, end):
    if start > end:
        return -1
    mid = (start+end)//2
    if num[mid] == target:
        return mid
    elif num[mid] > target:
        end = mid - 1
    else:
        start = mid + 1
    return binarySearch(target, start, end)
n = int(input())
num = list(map(int,input().split()))
m = int(input())
find = list(map(int,input().split()))
num.sort()

for i in range(m):
    start = 0
    end = n-1
    flag = binarySearch(find[i],start, end)
    if flag == -1:
        print(0)
    else:
        print(1)