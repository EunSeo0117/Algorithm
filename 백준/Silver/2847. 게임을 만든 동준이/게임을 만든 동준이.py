n = int(input())
li = []
count = 0
for i in range(n):
    li.append(int(input()))
    
for i in range(n-1):
    temp = li.pop()
    while temp <= li[-1]:
        li[-1] -=1
        count+=1
print(count)