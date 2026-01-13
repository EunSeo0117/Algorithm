n = input()
count = 0
for i in range(1,len(n)):
  temp = n[i]
  if n[i] != n[i-1]:
    count+=1
if count <= 1:
  print(count)
else:
  if count%2==0:
    print(count//2)
  else:
    print((count//2)+1)
# 전환점 찾아서 count+=1 1그리고 2하기 