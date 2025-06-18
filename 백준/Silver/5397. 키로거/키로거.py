n = int(input())
for _ in range(n):
    r_list = []
    l_list = []
    s = input()
    for k in s:
        if k == "-":
            if l_list:
                l_list.pop()
        elif k=="<":
            if l_list:
                r_list.append(l_list.pop())
        elif k==">":
            if r_list:
                l_list.append(r_list.pop())
        else:
            l_list.append(k)
    l_list.extend(reversed(r_list))
    print("".join(l_list))