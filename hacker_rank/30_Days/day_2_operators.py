#!/usr/local/bin/python3

meal_cost = float(input().strip())
tip_percent = int(input().strip())
tax_percent = int(input().strip())

tip = meal_cost * tip_percent/100.0
tax = meal_cost * tax_percent/100.0

totalCost = meal_cost + tip + tax
print('The total meal cost is {0:d} dollars.'.format(round(totalCost)))
