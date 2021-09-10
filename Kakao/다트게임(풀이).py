def solution(dartResult):
    point = []
    answer = []
    # 점수, 보너스, 옵션을 각각 배열에 넣어서 다루기
    # 10은 replace를 이용해 처리
    dartResult = dartResult.replace('10','k')
    point = ['10' if i == 'k' else i for i in dartResult]

#S,D,T는 따로 배열을 만들어서 in으로 처리
    i = -1
    sdt = ['S', 'D', 'T']
    for j in point:
        if j in sdt :
            answer[i] = answer[i] ** (sdt.index(j)+1)
        elif j == '*':
            answer[i] = answer[i] * 2
            if i != 0 :
                answer[i - 1] = answer[i - 1] * 2
        elif j == '#':
            answer[i] = answer[i] * (-1)
        else:
            answer.append(int(j))
            i += 1
    return sum(answer)

print(solution("1D2S3T*"))