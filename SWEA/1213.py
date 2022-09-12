import sys

sys.stdin = open("input.txt", "r", encoding="UTF-8")

for _ in range(10):
    t = int(input())
    k = input()
    s = input()

    print("#" + str(t) + " " + str(s.count(k)))
