#include "armstrong_numbers.h"
#include <stdio.h>
#include <math.h>

static int countDigits(int candidate) {
  int counter = 0;

  for (int i = candidate; i > 0; i = i / 10)
    counter++;

  return counter;
}

int is_armstrong_number(int candidate)
{
  int counter = countDigits(candidate);

  if (counter == 1)
    return 1;

  int zeros =0;
  int result = 0;
  int digits = counter; 
  int num = candidate;

  while (num > 0)
  {
    zeros = pow(10, counter - 1);
    result += pow(num / zeros, digits);
    num = num % zeros;
    counter--;
  }

  return result == candidate;
}

