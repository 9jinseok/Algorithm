def solution(queue1, queue2):
    l = len(queue1)
    ps = [queue1[0]]
    for i in range(1, l):
        ps.append(ps[i - 1] + queue1[i])
    for i in range(l, l * 2):
        ps.append(ps[i - 1] + queue2[i - l])
    S = ps[-1]
    ps.append(0)
    if S % 2 != 0:
        return -1
    S /= 2

    answer = 1e9
    for end in range(l * 2 - 1, 0, -1):
        start = 0
        mid = (start + end)//2 + 1
        while ps[end] - ps[mid] >= S:
            start = mid
            mid = (start + end)//2 + 1
# 0 7~1
        for i in range(start, end + 1):
            if ps[end] - ps[i - 1] == S:
                if end < l:
                    answer = min(answer, i + end + 1)
                else:
                    answer = min(answer, i + end + 1 - l)

    if answer == 1e9:
        return -1
    return answer

print(solution([1, 2, 1, 2], [1, 10, 1, 2]))
