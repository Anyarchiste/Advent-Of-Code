
# Challenge 1
def get_data():
    liste_line_b = []
    with open("Calories_per_item.txt", "r") as fp:
        for line in fp:
            liste_line_b.append(line)

    print(liste_line_b)
    return liste_line_b


def treat_data(liste_line_b):
    liste_line = []
    for e in liste_line_b:
        liste_line.append(e.replace("\n", ""))

    print(liste_line)

    list_per_elf_def = []
    list_per_x_elf = []
    for n in liste_line:
        if n == "":
            list_per_elf_def.append(list_per_x_elf)
            list_per_x_elf = []
        else:
            list_per_x_elf.append(n)

    list_per_elf_def.append(list_per_x_elf)

    print(list_per_elf_def)
    return list_per_elf_def


raw_data = get_data()
list_per_elf = treat_data(raw_data)

calories_per_elf = []
for s in list_per_elf:
    total_per_elf = 0
    for r in s:
        total_per_elf += int(r)
    calories_per_elf.append(total_per_elf)

print(calories_per_elf)

print(sorted(calories_per_elf, reverse=True))

# Challenge 2
top_3 = sorted(calories_per_elf, reverse=True)[0] + sorted(calories_per_elf, reverse=True)[1] + sorted(calories_per_elf, reverse=True)[2]

print(top_3)
