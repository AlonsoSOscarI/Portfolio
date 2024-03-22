class Node:
    def __init__(self, data, level, fval, parent=None):
        self.data = data
        self.level = level
        self.fval = fval
        self.parent = parent

    def generate_child(self):
        x, y = self.find(self.data, '_')
        val_list = [[x, y-1], [x, y+1], [x-1, y], [x+1, y]]  
        children = []
        for dx, dy in val_list:
            if 0 <= dx < len(self.data) and 0 <= dy < len(self.data[0]):
                if not (self.parent and self.parent.data[dx][dy] == '_'):
                    child = self.move(self.data, x, y, dx, dy)
                    if child is not None:
                        child_node = Node(child, self.level + 1, 0, self)  # Establecer el nodo actual como padre
                        children.append(child_node)
        return children

    def move(self, puz, x1, y1, x2, y2):
        if x2 >= 0 and x2 < len(puz) and y2 >= 0 and y2 < len(puz[0]):
            temp_puz = self.copy(puz)
            temp = temp_puz[x2][y2]
            temp_puz[x2][y2] = temp_puz[x1][y1]
            temp_puz[x1][y1] = temp
            return temp_puz
        else:
            return None

    def copy(self, root):
        temp = []
        for i in root:
            t = []
            for j in i:
                t.append(j)
            temp.append(t)
        return temp

    def find(self, puz, x):
        for i in range(0, len(puz)):
            for j in range(0, len(puz)):
                if puz[i][j] == x:
                    return i, j


class Puzzle:
    def __init__(self, size):
        self.n = size
        self.open = []
        self.closed = []
        self.goal = [["1", "2", "3"], ["4", "5", "6"], ["7", "8", "_"]]  # Matriz objetivo fijada

    def userPuzzle(self):
        puz = []
        print("Ingrese el estado inicial del 8Puzzle: ")
        for i in range(0, self.n):
            temp = input().split(" ")
            puz.append(temp)
        return puz

    def f(self, start, goal):
        return self.h(start.data, goal) + start.level

    def h(self, start, goal):
        temp = 0
        for i in range(0, self.n):
            for j in range(0, self.n):
                if start[i][j] != '_':
                    goal_i, goal_j = self.find_position_in_goal(goal, start[i][j])
                    temp += abs(i - goal_i) + abs(j - goal_j)
        return temp

    def find_position_in_goal(self, goal, value):
        for i in range(len(goal)):
            for j in range(len(goal[i])):
                if goal[i][j] == value:
                    return i, j

    def process(self):
        start = self.userPuzzle()
        start_node = Node(start, 0, 0)
        start_node.fval = self.f(start_node, self.goal)
        self.open.append(start_node)
        visited = set()

        while True:
            cur = self.open[0]

            if self.h(cur.data, self.goal) == 0:
                self.print_solution(cur)
                return

            visited.add(tuple(map(tuple, cur.data)))

            for child in cur.generate_child():
                child_state = tuple(map(tuple, child.data))
                if child_state not in visited:
                    child.fval = self.f(child, self.goal)
                    self.open.append(child)

            self.closed.append(cur)
            del self.open[0]
            self.open.sort(key=lambda x: x.fval)

    def print_solution(self, node):
        path = []
        while node:
            path.append(node)
            node = node.parent
        path.reverse()
        print("\nResolviendo el puzzle:")
        for i, state in enumerate(path):
            if i > 0:
                print("\nMovimiento", i, ":")
            self.print_state(state.data)
        print("\n¡Puzzle resuelto!")

    @staticmethod
    def print_state(state):
        for row in state:
            print(' '.join(row))
        print()

# Ejecutar el algoritmo
puz = Puzzle(3)
puz.process()
