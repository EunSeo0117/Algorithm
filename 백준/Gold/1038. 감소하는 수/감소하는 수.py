from itertools import combinations # 중복을 제외한 조합

n = int(input())
result = list()
for i in range(1,11):
    for j in combinations(range(0,10), i): #10중 1개 조합, 10중 2개조합,,,
        j = list(j)
        j.sort(reverse=True)
        result.append(int("".join(map(str, j))))
result.sort()
if n >= len(result):
    print(-1)
else:
    print(result[n])