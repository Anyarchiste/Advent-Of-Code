
# Launches challenge 1 if False, challenge 2 if True
challenge_2 = True


# Challenge 1
def get_data():
    raw_data_def = []
    with open("puzzle_input.txt", "r") as file:
        for line in file:
            raw_data_def.append(line)

        # Bug check
        print(raw_data_def)

    return raw_data_def


def treat_data(raw_data_def):
    clean_data = []
    for x in raw_data_def:
        clean_data.append(x.replace("\n", ""))
    print(clean_data)
    return clean_data


def points_dict(data_def):
    # Returns dict point player
    # A and X = 1 (rock)
    # B and Y = 2 (paper)
    # C and Z = 3 (scissors)
    # Winner = 6
    # Loser = 0
    # Draw = 3
    point_cheat_dict_player = {"A X": 4, "A Y": 8, "A Z": 3, "B X": 1, "B Y": 5, "B Z": 9, "C X": 7, "C Y": 2, "C Z": 6}
    return point_cheat_dict_player


def counting_points(dict_def, data_def):
    points_player = 0
    for x in data_def:
        points_player += dict_def[x]
    print(points_player)


raw_data = get_data()
data = treat_data(raw_data)
if not challenge_2:
    points_dict = points_dict(data)
    counting_points(points_dict, data)


# Challenge 2
# X = loose
# Y = draw
# Z = win
# A = 1 (rock)
# B = 2 (paper)
# C = 3 (scissors)
# Winner = 6
# Loser = 0
# Draw = 3

def points_dict_2(data_def):
    # Returns dict with points
    point_cheat_dict_player = {"A X": 3, "A Y": 4, "A Z": 8, "B X": 1, "B Y": 5, "B Z": 9, "C X": 2, "C Y": 6, "C Z": 7}
    return point_cheat_dict_player


if challenge_2:
    points_dict = points_dict_2(data)
    counting_points(points_dict, data)












