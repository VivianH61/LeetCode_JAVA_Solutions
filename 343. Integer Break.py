'''
Top down dp
num can be split into num - i and i
maxProd(n) = maxProd(n - i) * i
calculate for all i between (2, num), and keep track of the maxProd

basecase:
if num == 1, maxProd(1) = 1
if num == 2, 1 * 1 < 2 so return 2
if num == 3, 1 * 2 < 3 so return 3
=> if num <= 3, rather not spliting it, maxProd(num) = num

Time O(n^2)
there're n possible states of num, and due to memorization, we only calculate each state once
for each num, we iterate from 2 to num, which cost up to O(n)

Space O(n)
the recursion call stackcan grow up to O(n)

Bottom-up dp
start from base case (n <= 3) and iterate toward the answer
create an array dp of length n + 1
for i = 1, 2, 3, dp[i] = i

iterate num from 4 to n:
    ans = num (the case of not splitting the number at all)

class Solution:
    def integerBreak(self, n: int) -> int:
        @cache
        def getMaxProd(num):
            if num <= 3: # k >= 2
                return num
            maxProd = num
            for i in range(2, num):
                maxProd = max(maxProd, getMaxProd(num - i) * i)
            return maxProd
        if n <= 3:
            return n - 1
        return getMaxProd(n)
'''
class Solution:
    def integerBreak(self, n: int) -> int:
        if n <= 3: 
            return n - 1
        dp = [0] * (n + 1)
        # base case
        for i in [1, 2, 3]:
            dp[i] = i
        for num in range(4, n + 1):
            ans = 0
            for i in range(2, num):
                ans = max(ans, i * dp[num - i])
            dp[num] = ans
        return dp[n]