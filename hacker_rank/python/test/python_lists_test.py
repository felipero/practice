from unittest.mock import patch, MagicMock, call
from python import python_lists


def test_process_command_insert():
    lst = [3, 1, 2]
    new_lst = python_lists.process_command("insert 2 12", lst)
    assert [3, 1, 12, 2] == new_lst


def test_process_command_print():
    lst = [1, 3]
    python_lists.print = MagicMock()
    python_lists.process_command("print", lst)
    python_lists.print.assert_has_calls([call([1, 3])])


def test_process_command_remove():
    lst = [1, 3]
    new_lst = python_lists.process_command("remove 3", lst)
    assert [1] == new_lst


def test_process_command_append():
    lst = [1, 3]
    new_lst = python_lists.process_command("append 1", lst)
    assert [1, 3, 1] == new_lst


def test_process_command_sort():
    lst = [3, 1, 2]
    new_lst = python_lists.process_command("sort", lst)
    assert [1, 2, 3] == new_lst


def test_process_command_pop():
    lst = [3, 1, 2]
    new_lst = python_lists.process_command("pop", lst)
    assert [3, 1] == new_lst


def test_process_command_reverse():
    lst = [3, 1, 2]
    new_lst = python_lists.process_command("reverse", lst)
    assert [2, 1, 3] == new_lst


@patch('builtins.input')
def test_read_commands(input_mock):
    input_mock.side_effect = ["2", "append 2", "print"]
    python_lists.process_command = MagicMock(return_value=[1, 2, 3])
    assert [1, 2, 3] == python_lists.read_commands()
    python_lists.process_command.assert_has_calls([call("append 2", []), call("print", [1, 2, 3])])
