"""
부서진 키보드가 있습니다. 부서진 키보드는 공백을 입력하기 위한 스페이스바와 스페이스바 외의 다른 n개의 키만 사용이 가능합니다.
예를 들어 n이 4고 l, i, n, e 4개의 키를 사용할 수 있다고 했을 때, "line in line", "in    n          in"과 같은 문장을 만들 수 있습니다.
알파벳 대문자를 만들려면 shift키와 해당 알파벳의 소문자 키가 필요합니다.
예를 들어, "L I N e"을 완성하려면 shift, l, i, n, e 이렇게 5개의 키가 필요합니다.

당신은 이 부서진 키보드로 주어진 문자열 배열에 있는 문자열을 완성하면 완성한 문자열의 길이만큼 점수를 받는 게임을 하려고 합니다.
예를 들어, "coding is fun"이라는 문자열을 완성하면 13점을 얻을 수 있습니다.
단, 완성된 문자열 속에 알파벳 대문자가 있을 경우 알파벳 대문자 개수만큼 1점씩 추가로 점수를 얻을 수 있습니다.
예를 들어, "COding is fun"이라는 문자열을 완성하면 15(= 13 + 2)점을 얻을 수 있습니다.
문자열을 완전히 완성시키지 못하면 점수를 얻을 수 없습니다.
예를 들어, "abcde"라는 문자열을 "abc"까지만 완성하면 점수를 얻을 수 없습니다.

여러 개의 문자열을 담은 문자열 배열 sentences와 스페이스바 외에 사용 가능한 키의 개수를 나타내는 정수 n이 매개변수로 주어집니다.
이때, 얻을 수 있는 최대 점수를 return 하도록 solution 함수를 완성해주세요. 단, 완성할 수 있는 문자열이 없을 경우 0을 return 해주세요.
"""
def solution(sentences, n):
    answer = 0
    l = len(sentences)
    
    score = []
    for i in range(l):
        s = sentences[i]
        score.append([len(s),s])
        for c in s:
            if c.isupper():
                score[-1][0] += 1

    score.sort(reverse=True)
    
    cnt = [[] for _ in range(l)]
    for i in range(l):
        s = score[i][1]
        for c in s:
            if c != ' ' and not c.lower() in cnt[i]:
                cnt[i].append(c.lower())

    for i in range(l):
        for c in score[i][1]:
            if c.isupper() and not '^' in cnt[i]:
                cnt[i].append('^')

    keys = []
    for i in range(l):
        new_keys = keys.copy()
        for c in cnt[i]:
            if not c in new_keys:
                new_keys += c
        if len(new_keys) <= n:
            keys = new_keys
    print(keys)

    return answer

print(solution(["line in line", "LINE", "in lion"], 5))