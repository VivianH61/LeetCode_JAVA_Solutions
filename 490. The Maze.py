class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        visited = set()
        def dfs(x, y):
            visited.add((x, y))
            for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                x_new, y_new = x, y
                while x_new + dx >= 0 and x_new + dx < len(maze) and y_new + dy >= 0 and y_new + dy < len(maze[0]) and maze[x_new + dx][y_new + dy] == 0:
                    x_new += dx
                    y_new += dy
                if (x_new, y_new) in visited:
                    continue
                if x_new == destination[0] and y_new == destination[1]:
                    return True
                if dfs(x_new, y_new):
                    return True
            return False
        return dfs(start[0], start[1])