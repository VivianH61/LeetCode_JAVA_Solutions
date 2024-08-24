"""
Clarification:
for the subsequence, does it have to be consecutive? No
strictly increasing? yes

when going through the input, we need to make decision for each element
1. will it contribute to an existing increasing seq?
2. if including it in the seq, will it eliminate larger elements that came before it?

DP
1. need a func or array that represents the answer to the problem to a given state
array dp
dp[i] the length of the longest increasing subsequence that end with the i-th element

2. need a way to tansition between states
let's say we know dp[2], how do we know dp[3]?
knowing dp[2] is not enough, because it is possible that nums[3] <= nums[2] and nums[3] can only contribute to the increasing subsequence came before 
nums[2]
so we need the max of all dp[j] where nums[j] < nums[i]
=> dp[i] = max(dp[j]) + 1 where nums[j] < nums[i] and j < i

3. base case
initialize every element of dp to be 1, becasue every element can form a subsequence on its own
"""
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        maxLenOfLIS = [1] * n
        for i in range(n):
            maxLIS = 1
            for j in range(i):
                if nums[j] < nums[i]: #only worth consideration when nums[j] < nums[i]
                    maxLIS = max(maxLIS, maxLenOfLIS[j] + 1)
            maxLenOfLIS[i] = maxLIS
        return max(maxLenOfLIS)