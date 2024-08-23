"""
BFS
each index = node, appending a words to existing str = edge
find a path between index 0 to len(s)

how two nodes (index) are connected?
if the substr between 2 index is in the wordDict

use bfs to traverse the whole string
"""
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        queue = deque([0])
        visited = []
        words = set(wordDict)
        while queue:
            start = queue.popleft()
            if start == len(s):
                return True
            # iterate end from the right of start
            for end in range(start + 1, len(s) + 1):
                if end in visited:
                    continue
                if s[start:end] in words:
                    queue.append(end)
                    visited.append(end)
        return False

"""
Top down DP
create a function dp(i) that returns T/F indicating if its possible to build s in s[0:i]
s = "leetcode"
["leet", "code"]
dp(3) == true
base case dp(-1) = true, empty str
requirement for dp(i) to be true:
1. need a word in wordDict that ends in index i
2. if we find a word that end at i, we need to add it on the top of another str, which should be buildable
dp(i) = any(s[i - word.length + 1, i + 1] == word and dp(i - word.length))

Complexity:
n - length, m - len(wordDict), k - average length in wordDict
Time O(nmk)
Space O(n)
"""
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        def dp(i):
            if i < 0:
                return True
            for word in wordDict:
                if s[i - len(word) + 1: i + 1] == word and dp(i - len(word)):
                    return true
            return False
        return dp(len(s) - 1)
    
