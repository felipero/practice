import cProfile
import math


def is_prime(number, primes):
    m = int(math.sqrt(number) + 1)
    for prime in primes:
        if number % prime == 0:
            return False
        if prime > m:
            break

    return True


def nth_prime(n):
    if n < 2:
        return 2
    if n == 2:
        return 3
    if n == 3:
        return 5

    primes = [5]
    candidate, count, step = 7, 3, 2

    while count < n:
        if is_prime(candidate, primes):
            primes.append(candidate)
            count += 1

        step = 6-step
        candidate += step

    return primes.pop()


nth = 1_000_001 # 15_485_857
cProfile.run('print(nth_prime(' + str(nth) + '))')


def sieve_primes(n):
    # http://stackoverflow.com/questions/2068372/fastest-way-to-list-all-primes-below-n-in-python/3035188#3035188
    """ Returns  a list of primes < n """
    sieve = [True] * n
    for i in range(3, int(math.sqrt(n))+1, 2):
        if sieve[i]:
            sieve[i*i::2*i] = [False] * int((n-i*i-1)/(2*i)+1)
    return [2] + [i for i in range(3, n, 2) if sieve[i]]


# cProfile.run('print(sieve_primes(104_744))')
