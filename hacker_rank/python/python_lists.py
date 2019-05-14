
def process_args(args):
    return map(int, args)


def process_command(command_line, lst):
    command, *tail = command_line.split(' ')
    args = process_args(tail)
    commands = {'insert': lst.insert,
                'print': lambda: print(lst),
                'remove': lst.remove,
                'append': lst.append,
                'sort': lst.sort,
                'pop': lst.pop,
                'reverse': lst.reverse, }
    commands[command](*args)
    return lst


def read_commands():
    n = int(input())
    lst = []
    while n > 0:
        lst = process_command(input(), lst)
        n -= 1

    return lst
