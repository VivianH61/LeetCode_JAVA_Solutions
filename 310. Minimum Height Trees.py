"""
height of tree for different node as root:
the max path from root to child nodes

find the root that has min height tree

Approach 1: Topological Sorting
=》 need to find the nodes thatare overall close to all other nodes, especially the leaf nodes

initialize
since its undirected, for each node, maintain a list of neighbors

At beginning, put all leaf nodes into the queue
recursively remove leaf node from the tree
"""
class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n <= 2:
            return [i for i in range(n)]
        neighbors = [set() for _ in range(n)]
        for x, y in edges:
            neighbors[x].add(y)
            neighbors[y].add(x)
        
        leaves = []
        for i in range(n):
            if len(neighbors[i]) == 1:
                leaves.append(i)
        remainingNodes = n
        while remainingNodes > 2:
            remainingNodes -= len(leaves)
            new_leaves = []
            while leaves:
                leaf = leaves.pop()
                # the only neighbor that the current leaf has
                neighbor = neighbors[leaf].pop()
                neighbors[neighbor].remove(leaf)
                if len(neighbors[neighbor]) == 1:
                    new_leaves.append(neighbor)
            leaves = new_leaves
        return leaves