n, k = map(int, input().split())
answer = 0
digit = 1
nine = 9
while k > digit*nine:
    k = k-(digit * nine)
    answer = answer + nine
    digit+=1
    nine = nine*10
answer = (answer+1) + (k-1) // digit
if answer > n:
    print(-1)
else:
    print(str(answer)[(k-1)%digit])
