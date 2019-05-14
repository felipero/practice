from unittest.mock import patch
from python import np_linear_algebra


def test_matrix_det():
    matrix = [[1, 2], [3, 4]]
    assert np_linear_algebra.matrix_det(matrix) == -2.0


def test_convert_to_array_matrix():
    row = "1.3 1.4 1.5"
    assert np_linear_algebra.convert_to_array_matrix(row) == [1.3, 1.4, 1.5]


@patch('builtins.input')
def test_read_from_input(input_mock):
    input_mock.side_effect = ["2", "1.2 3", "1.5 1.6"]
    arr = np_linear_algebra.read_from_input()
    assert arr == [[1.2, 3], [1.5, 1.6]]
