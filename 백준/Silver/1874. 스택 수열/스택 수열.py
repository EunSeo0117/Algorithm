from sys import stdin
n = int(stdin.readline())
stack, answer, find = [],[],True
now = 1
for _ in range(n):
    num = int(stdin.readline())
    while now <= num:
        stack.append(now)
        answer.append("+")
        now +=1
    if stack[-1] ==num: # -1은 맨뒤를 참조하게됨
        stack.pop()
        answer.append("-")
    else:
        find = False
if not find:
    print("NO")
else:
    for i in answer:
        print(i)