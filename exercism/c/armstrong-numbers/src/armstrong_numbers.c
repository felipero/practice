#include "armstrong_numbers.h"
#include <stdio.h>
#include <math.h>

int is_armstrong_number(int candidate)
{
  int counter = 0;

  for (int i = candidate; i > 0; i = i / 10)
    counter++;

  if (counter == 1)
    return 1;

  int zeros, result = 0, digits = counter, num = candidate;

  while (num > 0)
  {
    zeros = pow(10, counter - 1);
    result += pow(num / zeros, digits);
    num = num % zeros;
    counter--;
  }

  return result == candidate;
}
