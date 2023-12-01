
def get_data():
    raw_data = []
    with open("Day4\PuzzleInput.txt", "r") as f:
        for line in f:
            raw_data.append(line.replace("\n", ""))
    print(raw_data)

    data_def = []
    for n in raw_data:
        lol = n.split(",")
        for y in lol:
            data_def.append(y)
        
    print(data_def)


data = get_data()
