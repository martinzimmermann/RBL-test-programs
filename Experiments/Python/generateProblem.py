import argparse

parser = argparse.ArgumentParser(description='Creates a Problem of a NxN maze')
parser.add_argument('--warehouse', action='store_true')
parser.add_argument('N', metavar='N', type=int,
                   help='X and Y dimensions of the maze')
args = parser.parse_args()
X = args.N
Y = args.N
if(args.warehouse == False):
    with open("problem.pddl", "w") as f:
        rooms = []
        for x in range(X):
            for y in range(Y):
                rooms.append(f'room_{x}_{y}')

        f.write(r"""(define (problem strips-robot)
    (:domain robot-strips)
    (:objects """)
        for room in rooms:
                f.write(room + ' ')
        f.write(r""")
    (:init (at room_0_0)
""")
        for x in range(X):
            for y in range(Y-1):
                f.write(f'           (connected room_{x}_{y} room_{x}_{y+1})\n')
                f.write(f'           (connected room_{x}_{y+1} room_{x}_{y})\n')
        for y in range(Y):
            for x in range(X-1):
                f.write(f'           (connected room_{x}_{y} room_{x+1}_{y})\n')
                f.write(f'           (connected room_{x+1}_{y} room_{x}_{y})\n')
        f.write(r"""    )
    (:goal (and )))""")
else:
    if(args.N % 3 != 2 or args.N == 2):
        print("N must be bigger than 2 and N % 3 must be 2(e.g., 5, 8, 11, ...)")
        exit(1)
    with open("problem.pddl", "w") as f:
        rooms = []
        for x in range(X):
            for y in range(Y):
                rooms.append(f'room_{x}_{y}')

        f.write(r"""(define (problem strips-robot)
    (:domain robot-strips)
    (:objects """)
        for room in rooms:
                f.write(room + ' ')
        f.write(r""")
    (:init (at room_0_0)
""")
        for x in range(X):
            for y in range(Y-1):
                if((x % 3 == 2) and y > 0):
                    continue
                f.write(f'           (connected room_{x}_{y} room_{x}_{y+1})\n')
                f.write(f'           (connected room_{x}_{y+1} room_{x}_{y})\n')
        for y in range(Y):
            for x in range(X-1):
                if((x % 3 == 1 or x % 3 == 2) and y > 1):
                    continue
                f.write(f'           (connected room_{x}_{y} room_{x+1}_{y})\n')
                f.write(f'           (connected room_{x+1}_{y} room_{x}_{y})\n')
        f.write(r"""    )
    (:goal (and )))""")

    lines = []
    for x in range(X-1 , -1, -1):
        line = []
        for y in range(Y):
            if (x % 3 == 2) and y == 1:
                line.append("0xB")
            elif x != 0 and x != X-1 and (x % 3 == 0) and y > 1:
                line.append("0xD")
            elif x != 0 and x != X-1 and (x % 3 == 1) and y > 1:
                line.append("0x7")
            elif x != 0 and x != X-1 and (x % 3 == 2) and y > 1:
                line.append("0x0")
            else:
                line.append("0xF")
        lines.append("[" + ", ".join(line) + "]")
    print(",\n".join(lines))