class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res = []
        n = len(candidates)
        def backtrack(remain, comb, i):
            if remain < 0 or i == n:
                return
            if remain == 0:
                res.append(list(comb))
                return 
            comb.append(candidates[i])
            backtrack(remain - candidates[i], comb, i)
            comb.pop()
            backtrack(remain, comb, i + 1)
        backtrack(target, [], 0)
        return res