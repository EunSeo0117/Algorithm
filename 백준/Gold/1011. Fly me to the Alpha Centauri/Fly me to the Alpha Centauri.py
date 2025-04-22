n = int(input())
for i in range(n):
    x, y = map(int, input().split())
    distance = y - x
    tmp = 0 # 이동거리
    cnt = 0 # 공간장치 이동횟수
    moving = 0 # 반복횟수
    while tmp < distance:
        cnt +=1
        if cnt % 2 !=0:
            moving +=1
        tmp += moving
    print(cnt)
        