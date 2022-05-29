/* 
Approach 1: using stack
Observations: 
If the current operation is (+) or (-), then we need to look at the following operations.
(For example, 4+3 should be evaluated later, because the following expressions might be 4+3*8)
If the current operation is (*) or (/), it is irrespective of the next ooperation.
Algorithm:
Scan the input s from left to right and evaluate the expression based on the following rules.
1. if the current character is a digit 0-9, add it to the currentNumebr
2. otherwise, evaluate the expression baed on the type of operations.
   (1) (+) or (-), push the currentNumber into the stack
   (2) (*) or (/), pop the top values from the stack and evaluate the current value,. Push the evaluated value back to the stack.
After the s is scanned, pop from the stack and add it to the result.
*/
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int curNumber = 0;
        char operation = '+';
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (Character.isDigit(curChar)) {
                curNumber = curNumber * 10 + (curChar - '0');
            }
            
            if ((!Character.isDigit(curChar) && !Character.isWhitespace(curChar)) || i == s.length() - 1) {
                if (operation == '-') {
                    stack.push(-curNumber);
                } else if (operation == '+') {
                    stack.push(curNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * curNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / curNumber);
                }
                operation = curChar;
                curNumber = 0;
            }
            
            
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}