def solution(m, n, board):
    while True:
        pos = []
        for i in range(m-1):
            for j in range(n-1):
                if board[i][j] == "-":
                    continue
                if board[i][j] == board[i][j+1] and board[i+1][j] == board[i][j+1] and board[i+1][j] == board[i+1][j+1]:
                    pos.append((i,j))

        if len(pos) == 0:
            break

        for x, y in pos:
            board[x] = board[x][:y] + "-" + board[x][y+1:]
            board[x+1] = board[x+1][:y] + "-" + board[x+1][y+1:]
            board[x] = board[x][:y+1] + "-" + board[x][y+2:]
            board[x+1] = board[x+1][:y+1] + "-" + board[x+1][y+2:]

        for j in range(n):
            idx = m-1
            for _ in range(m):
                if board[idx][j] == '-':
                    for i in range(idx,0,-1):
                        board[i] = board[i][:j] + board[i-1][j] + board[i][j+1:]
                    board[0] = board[0][:j] + "-" + board[0][j+1:]
                else:
                    idx -= 1
    
    ans = 0
    for i in range(m):
        ans += board[i].count('-')
    return ans

print(solution(6,6,["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]))