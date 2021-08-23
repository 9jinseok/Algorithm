def solution(message, K):
    msg = message.split()

    if len(msg[0]) > K:
        return ""
    ans = msg[0]
    for i in range(1,len(msg)):
        if len(ans + " " + msg[i]) > K:
            break
        ans += " " + msg[i]
    return ans

print(solution("Why not",14))