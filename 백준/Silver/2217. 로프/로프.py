n = int(input())
max = 0
li = []
for i in range(n):
  li.append(int(input()))
li.sort()
for i in range(n):
  temp = li[i]*n
  if max < temp:
    max = temp
  n-=1
print(max)
