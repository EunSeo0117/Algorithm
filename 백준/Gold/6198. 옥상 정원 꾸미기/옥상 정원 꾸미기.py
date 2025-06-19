from sys import stdin
n = int(stdin.readline())
building =[] 
for i in range(n):
    building.append(int(stdin.readline()))
stack = [] 
result = 0
for i in building: 
    while stack and stack[-1] <= i: # 못보는 크기는 빼줌
        stack.pop()
    stack.append(i) # 오른쪽만 볼수있으므로 빌딩을 스택에 넣고 다음포문에서,
                    # 스택안의 빌딩이 다음빌딩을 볼수있는지 없는지 판단
    result += len(stack)-1 # 볼수있는길이 계산(자기자신은 뻄)
print(result)