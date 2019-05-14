def is_leap(year):
    return is_mod_4_not_100(year) or is_mod_100_and_400(year)


def is_mod_4_not_100(year):
    return year % 4 == 0 and not year % 100 == 0


def is_mod_100_and_400(year):
    return year % 100 == 0 and year % 400 == 0
# year = int(input())
# print(is_leap(year))
