# Multiples of 3 and 5

multiples_sum = 3
n = 1000

for num in range(4, n):
    if (not num % 3) or (not num % 5):
        multiples_sum += num

print(multiples_sum)
