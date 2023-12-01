
def get_data():
    data_def = ""
    with open("puzzle_input.txt", "r") as f:
        for line in f:
            line_2 = line.replace("\n", "")
            data_def += line_2
    print(data_def)

    return data_def


def parsing(data_def):
    low_marker = 0
    high_marker = 4
    if data_def[low_marker] in data_def[low_marker + 1, high_marker]:
        low_marker += 1
        high_marker += 1



def get_solution(data_def):


data = get_data()
parsed_data = parsing(data)
get_solution(parsed_data)
