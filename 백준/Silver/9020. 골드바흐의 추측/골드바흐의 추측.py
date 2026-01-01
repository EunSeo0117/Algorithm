from sys import stdin
import math
def isP(N):
    if N==1:
        return False
    for i in range(2, int(math.sqrt(N))+1):
        if N%i == 0:
            return False
    return True
n = int(stdin.readline())
for i in range(n):
    k = int(stdin.readline())
    A = k//2
    B = k//2
    for j in range(k//2):
        if isP(A) and isP(B):
            print(A,B)
            break
        else:
            A-=1
            B+=1
                