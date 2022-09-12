def solution(student, k):
    answer = 0
    
    idx = 0
    while True:
        if student[idx+1:].count(1) < k:
            break

        left = 0
        cnt = 0
        for i in range(idx,len(student)):
            if student[i] == 0:
                left += 1
            else:
                cnt += 1
                idx = i
                break
        
        next = idx
        idx += 1
        while cnt < k:
            next += 1
            if student[next] == 1:
                cnt += 1

        right = 0
        for i in range(next+1, len(student)):
            if student[i] == 0:
                right += 1
            else:
                break
        
        answer += (left+1) * (right+1)

    return answer

print(solution([0, 1, 0],2))