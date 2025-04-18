n, m = map(int, input().split())
li = list(map(int,input().split()))
for i in range(m):
    li.sort()
    temp = li[0]+li[1]
    li[0] = temp
    li[1] = temp
print(sum(li))