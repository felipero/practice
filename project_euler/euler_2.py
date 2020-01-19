N = int(input()) # 2
M = pow(10, 9) + 7

for test in range(N):
    n = int(input())
    s_n = n**2
    print(s_n%M)
