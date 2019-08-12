#
#
# ak < 40000000 < 3 + 4*(k-1)
# 4M < 4k + 3  - 4
# 4M < 4k -1
# 4k > 4000000 + 1
# 4k > 4000001
# k > 10000001
#

def seq_plus_3(n_final):
    seq = []
    for n in range(1, n_final + 1):
        a_n = 1 + 3 * (n - 1)
        seq.append(a_n)

    return seq

def nth_term_of_seq_plus_4(n):
    return 3 + 4 * (n - 1)


def fib(max_term):
    term, next_term = 0, 1
    seq = []
    while term < max_term:
        seq.append(term)
        term, next_term = next_term, term + next_term

    return seq

print( nth_term_of_seq_plus_4(100000000) )
