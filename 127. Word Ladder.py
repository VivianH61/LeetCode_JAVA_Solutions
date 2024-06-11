# '''
# undirected and unweighted graph
# use bfs to find the shortest path between the beginWord and endWord
# wordlist -> intermediate nodes
# there's only 1 letter diff between neighbors
# Pre-processing
# -> how to find adjacent nodes?
# 1. use generic states, replacing every letter of a word by * aesterisk, hat -> h*t <- hit
# dict {d*g : [dag, dig]..}
# so that during bfs, to find e.g dig's neighbors, we just need to find all words that share generic mappings with dig
# 2. use a visited {} to prevent cycles
# 3. at the beginning level is 0, append (cur_word, level + 1) into the queue
# '''
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        wordListDict = defaultdict(set)
        for word in wordList:
            for i in range(len(word)):
                wordListDict[word[:i] + '*' + word[i + 1:]].add(word)
        # bfs
        visited = {}
        queue = []
        queue.append((beginWord, 1))
        while queue:
            curWord, level = queue.pop(0)
            # for current word, find the neighbors for each generic words
            for i in range(len(curWord)):
                # replace the character at index i with aesterisk
                genericWord = curWord[:i] + '*' + curWord[i + 1:]
                for nextWord in wordListDict[genericWord]:
                    if nextWord in visited:
                        continue
                    if nextWord == endWord:
                        return level + 1
                    visited[nextWord] = True
                    queue.append((nextWord, level + 1))
        return 0
