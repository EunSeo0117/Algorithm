from collections import deque
t = int(input())     # 테스트케이스 개수
for i in range(t):
    p=input().strip()
    n=int(input())
    flag=1
    temp = input().strip()
    que = deque(temp[1:-1].split(',')) # 1~-1 => [와]제거
    if n==0:
        que = deque()
    R=0
    for i in range(len(p)):
        if p[i]=="R":
            R+=1
        elif p[i]=="D":
            if len(que)==0:
                print("error")
                flag=0
                break
            else:
                if R%2==0:
                    que.popleft()
                else:
                    que.pop()
    if flag == 0:
        continue
    else:
        if R%2==0:
            print('[' + ",".join(que) +"]")
        else:
            que.reverse()
            print('[' + ",".join(que) +"]")  