
def solution(logs):
    answer = 0

    for log in logs:
        if len(log) > 100:
            answer += 1
            continue
        if log.count(' ') != 11:
            answer += 1
            continue
        tmp = log.split()
        if len(tmp) != 12:
            answer += 1
            continue
        if tmp[0] != 'team_name' or tmp[1] != ':':
            answer += 1
            continue
        if tmp[3] != 'application_name' or tmp[4] != ':':
            answer += 1
            continue
        if tmp[6] != 'error_level' or tmp[7] != ':':
            answer += 1
            continue
        if tmp[9] != 'message' or tmp[10] != ':':
            answer += 1
            continue
        str = tmp[2] + tmp[5] + tmp[8] + tmp[11]
        if not str.isalpha():
            answer += 1
            continue

    return answer

print(solution(["team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange", "no such file or directory", "team_name : recommend application_name : recommend error_level : info message : RecommendSucces11", "team_name : recommend application_name : recommend error_level : info message : Success!", "   team_name : db application_name : dbtest error_level : info message : test", "team_name     : db application_name : dbtest error_level : info message : test", "team_name : TeamTest application_name : TestApplication error_level : info message : ThereIsNoError"]))