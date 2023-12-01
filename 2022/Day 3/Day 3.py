import string

# Launches Challenge 1 if False, challenge 2 if True
challenge_2 = True


# Challenge 1
def get_data():
    data_def = []
    with open("puzzle_input.txt", "r") as file:
        for line in file:
            data_def.append(line)
    return data_def


def treat_data(raw_data_def):
    data_def = []
    for e in range(len(raw_data_def)):
        data_def.append(raw_data_def[e].replace("\n", ""))
    return data_def


def set_priorities():
    priorities_def = {}
    letters = string.ascii_lowercase + string.ascii_uppercase
    letter_prio = 0
    for letter in letters:
        letter_prio += 1
        priorities_def[letter] = letter_prio
    return priorities_def


def is_in_both_halves(half1_def, half2_def, doubled_items_def):
    shit = ""
    for x in half1_def:
        if x in half2_def:
            if x not in shit:
                doubled_items_def.append(x)
                shit += f"{x}"


def get_doubled_items(data_def):
    doubled_items_def = []
    for n in range(len(data_def)):
        half_1 = data_def[n][:len(data_def[n]) // 2]
        half_2 = data_def[n][len(data_def[n]) // 2:]
        is_in_both_halves(half_1, half_2, doubled_items_def)
    return doubled_items_def


def get_sum(prio_def, items_def):
    sum_def = 0
    for x in items_def:
        sum_def += prio_def[x]
    return sum_def


raw_data = get_data()
data = treat_data(raw_data)
priorities = set_priorities()
if not challenge_2:
    doubled_items = get_doubled_items(data)
    sum_of_priorities = get_sum(priorities, doubled_items)

    print(sum_of_priorities)


# Challenge 2
def get_common_item(data_def, groups_number):
    common_item_def = []
    data_def_2 = []
    for x in data_def:
        data_def_2.append(x)
    print(data_def_2)
    for i in range(groups_number):
        dump = []
        for x in data_def_2[0]:
            if x in data_def_2[1] and x in data_def_2[2] and x not in dump:
                common_item_def.append(x)
                dump.append(x)
                del data_def_2[len(data_def_2) - 3:]
                print(dump)
    return common_item_def


def arrange_data(data_def, groups_number):
    arranged_data = []
    t = 2
    for v in range(groups_number):
        for y in range(t):
            arranged_data.append(data_def[y])
        del data_def[:t]

    return arranged_data


if challenge_2:
    number_of_groups = 3
    data_cha_2 = arrange_data(data, number_of_groups)
    print(data_cha_2)
    common_item = get_common_item(data_cha_2, number_of_groups)

    print(common_item)
