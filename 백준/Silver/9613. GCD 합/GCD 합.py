def GCD(a,b):
    tem,n = 0, 0
    if a<b:
        tem = a
        a = b
        b = tem
    while b!=0:
        r = a%b
        a = b
        b = r
    return a
n = int(input())
for i in range(n):
    li = list(map(int, input().split()))
    li.pop(0)
    answer = 0
    for k in range(len(li)-1):
        for j in range(k+1,len(li)):
            answer += GCD(li[k],li[j])
    print(answer)