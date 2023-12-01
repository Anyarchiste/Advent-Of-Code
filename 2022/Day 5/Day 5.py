import queue as queue
import re


def get_crates():
    qu = queue.LifoQueue()
    queue_list = []
    with open("crates.txt") as e:
        file = e.read()
        lines = file.split("\n")
    for x in lines:
        q_list = x.split(",")
        for y in q_list:
            qu.put(y)
        queue_list.append(qu)
        qu = queue.LifoQueue()
    return queue_list


"""move 1 from 2 to 1 --> 121"""
def get_moves():
    raw_moves = []
    with open("moves.txt", "r") as f:
        for lines in f:
            raw_moves.append(re.findall(r'\d+', lines))
    return raw_moves


"""move 1 from 2 to 1 --> 121"""
def move_crates(crates_def, moves_def):
    for move in moves_def:
        for y in range(int(move[0])):
            to_displace = crates_def[int(move[1])-1].get()
            crates_def[int(move[2])-1].put(to_displace)
    return crates_def


crates = get_crates()
moves = get_moves()
piles = move_crates(crates, moves)

for v in range(len(piles)):
    print(piles[v].get())
