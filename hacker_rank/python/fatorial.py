# import math
# from decimal import *

# getcontext().prec = 20

fatorial = 1

# n = Decimal(math.pi)
n = 5

# fatorial = Decimal(2 * Decimal(math.pi) * n).sqrt() * ( (n / Decimal(math.e) ) ** n )


for fator in range(1, n+1):
    fatorial *= fator

print(fatorial)
