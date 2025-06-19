import sys
input = sys.stdin.readline
n, k = map(int,input().split())
table = input().rstrip()
t = list(table)
count = 0
for i in range(len(t)):
    if t[i]=="P":
        for j in range(i-k, i+k+1):
            if 0 <= j < n and t[j] == "H":
                count+=1
                t[j] = "0"
                break 
print(count)
        