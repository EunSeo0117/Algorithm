m,n = map(int, input().split())
primelist = [True] * (int(n**0.5)+1)
primelist[1] = False
for i in range(2, int(n**0.5)+1):
    if primelist[i]:
        if i*i > int(n**0.5):
            break
        for j in range(i**2, int(n**0.5)+1, i):
            primelist[j] = False
count = 0
for i in range(1,len(primelist)):
    if primelist[i]:
        res = i*i
        while True:
            if res < m:
                res *= i
                continue
            if res > n:
                break
            res *= i
            count +=1
print(count)