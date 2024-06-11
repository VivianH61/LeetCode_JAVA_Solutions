'''
Approach BFS
Start BFS from every 1 and once it reaches 0, we stop the search.
but in the worst case, if the matrix is full of 1, then the time complexity will be M^2N^2
thinking about an alternative way: start the bfs from 0, skip those cells that are already visited
Space optimization:
Any cell with value 0 doesn't have to be changed, change 1 to None, then we only put None to the queue during bfs
Time: O(M * N), where M is number of rows, N is number of columns in the matrix.
Space: O(M * N), space for the queue.
'''
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = []
        M, N = len(mat), len(mat[0])
        for x in range(M):
            for y in range(N):
                if mat[x][y] == 0:
                    queue.append((x, y))
                else:
                    mat[x][y] = None
        while queue:
            x, y = queue.pop(0)
            for x_next, y_next in [(x, y + 1), (x, y - 1), (x + 1, y), (x - 1, y)]:
                if x_next < 0 or x_next >= M or y_next < 0 or y_next >= N:
                    continue
                if mat[x_next][y_next] != None: 
                    continue
                mat[x_next][y_next] = mat[x][y] + 1
                queue.append((x_next, y_next))
        return mat