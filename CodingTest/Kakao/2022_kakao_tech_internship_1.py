def solution(survey, choices):
    answer = ''

    score = [0] * 8

    d = dict()
    d['R'] = 0
    d['T'] = 1
    d['C'] = 2
    d['F'] = 3
    d['J'] = 4
    d['M'] = 5
    d['A'] = 6
    d['N'] = 7

    for i in range(len(survey)):
        neg = survey[i][0]
        pos = survey[i][1]

        if choices[i] == 1:
            score[d[neg]] += 3
        elif choices[i] == 2:
            score[d[neg]] += 2
        elif choices[i] == 3:
            score[d[neg]] += 1
        elif choices[i] == 5:
            score[d[pos]] += 1
        elif choices[i] == 6:
            score[d[pos]] += 2
        elif choices[i] == 7:
            score[d[pos]] += 3

    if score[0] >= score[1]:
        answer += 'R'
    else:
        answer += 'T'

    if score[2] >= score[3]:
        answer += 'C'
    else:
        answer += 'F'
    if score[4] >= score[5]:
        answer += 'J'
    else:
        answer += 'M'
    if score[6] >= score[7]:
        answer += 'A'
    else:
        answer += 'N'

    return answer

print(solution(["AN", "CF", "MJ", "RT", "NA"],[5, 3, 2, 7, 5]))