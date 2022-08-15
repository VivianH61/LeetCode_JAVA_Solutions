'''
break the solution down into several parts
1. find connected components in the graph
2. sort the characters in each compoments
'''
from collections import defaultdict
class UnionFind:
    def __init__(self, n):
        self.root = list(range(n))
        self.rank = [1] * n
    
    def find(self, x: int):
        if x == self.root[x]:
            return x
        self.root[x] = self.find(self.root[x])
        return self.root[x]
    
    def union(self, x, y):
        rootX, rootY = self.find(x), self.find(y)
        if (rootX != rootY):
            if (self.root[rootX] >= self.root[rootY]):
                self.root[rootY] = self.root[rootX]
                self.rank[rootX] += self.rank[rootY]
            else:
                self.root[rootX] = self.root[rootY]
                self.rank[rootY] += self.rank[rootX]
                
    
class Solution:
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
        s = list(s)
        uf = UnionFind(len(s))
        for src, dest in pairs:
            uf.union(src, dest)
        root2component = defaultdict(list)
        for i in range(len(s)):
            root = uf.find(i)
            root2component[root].append(i)
            
        for root in root2component:
            chars = sorted([s[i] for i in root2component[root]])
            for count, i in enumerate(root2component[root]):
                s[i] = chars[count]
        return ''.join(s)