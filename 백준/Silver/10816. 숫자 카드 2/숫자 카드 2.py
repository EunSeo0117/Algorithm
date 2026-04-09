import sys
input = sys.stdin.readline 
n = int(input())
pocket = list(map(int, input().split()))
m = int(input())
find=list(map(int,input().split()))
pocket.sort()

dic =dict()
for i in pocket:
    try: dic[i] +=1
    except:
        dic[i] = 1
for i in find:
    try: print(dic[i], end=" ")
    except: print(0, end=" ")
