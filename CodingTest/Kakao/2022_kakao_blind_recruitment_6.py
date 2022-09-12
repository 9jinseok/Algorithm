import numpy as np

def solution(board, skill):
    board = np.array(board)

    for s in skill:
        d = s[5]
        if s[0] == 1:
            d *= -1

        board[s[1]:s[3]+1,s[2]:s[4]+1] += d

    return len(board[board > 0])

print(solution([[1, 2, 3], [4, 5, 6], [7, 8, 9]], [[1, 1, 1, 2, 2, 4], [1, 0, 0, 1, 1, 2], [2, 2, 0, 2, 0, 100]]))