from numpy import linalg


def matrix_det(array_matrix=[]):
    return round(linalg.det(array_matrix), 1)


def convert_to_array_matrix(str=''):
    return list(map(float, str.split(' ')))


def read_from_input():
    n = int(input())
    num_of_rows = n
    matrix_array = []
    while num_of_rows > 0:
        row = input()
        matrix_array.append(convert_to_array_matrix(row))
        num_of_rows -= 1

    return matrix_array
