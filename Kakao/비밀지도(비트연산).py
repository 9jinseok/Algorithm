def solution(n, arr1, arr2):
    answer = []

    # 내장함수 zip()이용해서 for문 같이 돌리기
    for i,j in zip(arr1,arr2):
        # 비트연산 | 이용 / bin() 함수 : "0b"로 시작하는 이진수 반환
        l = bin(i|j)[2:]
        # rjust() : n보다 부족한 글자만큼 '0'으로 채움
        l = l.rjust(n,'0')
        l = l.replace('1',"#")
        l = l.replace('0',' ')
        answer.append(l)

    return answer
