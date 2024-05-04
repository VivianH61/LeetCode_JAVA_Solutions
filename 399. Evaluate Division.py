'''
Path search in a weighted & directed graph
1. build the graph from the input equations
each equation equal to two edges in the graph
2. search the path between the given two variables
two exceptional cases:
(1) either node does not exist in the graph
(2) origin and destination are the same node, i.e. a/a
'''
class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        G = defaultdict(defaultdict)
        # build the graph
        for (a, b), val in zip(equations, values):
            G[a][b] = val
            G[b][a] = 1 / val
        def backtrack(src, dest, prod, visited):
            visited.append(src)
            res = -1
            if dest in G[src]:
                return prod * G[src][dest]
            for nextSrc in G[src]:
                if nextSrc in visited:
                    continue
                res = backtrack(nextSrc, dest, prod * G[src][nextSrc], visited)
                if res != -1:
                    break
            visited.pop()
            return res
                
            
        # evaluate each query by backtracking
        res = []
        for src, dest in queries:
            if src not in G or dest not in G:
                res.append(-1)
                continue
            if src == dest:
                res.append(1)
                continue
            visited = []
            res.append(backtrack(src, dest, 1, visited))
        return res
            
        
        