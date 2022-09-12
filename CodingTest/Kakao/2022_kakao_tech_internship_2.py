from collections import deque

def solution(queue1, queue2):
    S = (sum(queue1) + sum(queue2))

    if S % 2 != 0:
        return -1

    S /= 2

    l = len(queue1)
    q = queue1[:]
    for i in queue2:
        q.append(i)

    for i in range(l):
        for j in range(l - i, l * 2):
            if sum(q[:j]) == S:
                return j - l + i + i
        if i == l * 2 - 1:
            break
        tmp = q[0]
        q = q[1:]
        q.append(tmp)

    q = queue2[:]
    for i in queue1:
        q.append(i)

    for i in range(l):
        for j in range(l - i, l * 2):
            if sum(q[:j]) == S:
                return j - l + i + i
        if i == l * 2 - 1:
            break
        tmp = q[0]
        q = q[1:]
        q.append(tmp)

    return -1


