'''
Approach 1 Brute Force
Check every substring and check their valibility
Time O(n^3)
Space O(n) a stack of depth n is required

Approach 2 using stack
push the index of the open paretheses '(' and pop when there's a colsed parenthese ')'
Every time if the stack is empty, push the current index to stack and update length, this 
is keep track of the index before the possible beginning of the valid substring
first push -1 to the stack 
'''
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack = [-1]
        maxLen = 0
        for i, ch in enumerate(s):
            if ch == '(':
                stack.append(i)
            else:
                stack.pop()
                if stack == []:
                    stack.append(i)
                else:
                    maxLen = max(maxLen, i - stack[-1])
        return maxLen