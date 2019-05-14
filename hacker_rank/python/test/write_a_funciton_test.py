from python import write_a_function

is_leap = write_a_function.is_leap


def test_is_leap_mod_4():
    print('Year divisible by 4 and not 100')
    assert is_leap(2016)


def test_is_leap_mod_4_and_100():
    print('Year divisible by 4 and 100')
    assert not is_leap(1800)


def test_is_leap_mod_4_and_100_and_400():
    print('Year divisible by 4 and 100 and 400')
    assert is_leap(2400)
