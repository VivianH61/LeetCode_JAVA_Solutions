/*Approach 1: expand from center*/
class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String maxSeq = "";
        // character as the center
        for (int i = 0; i < s.length(); i ++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l --;
                r ++;
            }
            if (r - l - 1 > maxLen) {
                maxLen = r - l - 1;
                maxSeq = s.substring(l + 1, r);
            }
        }
        // space as the center
        for (int i = 0; i < s.length() - 1; i ++) {
            int l = i, r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l --;
                r ++;
            }
            if (r - l - 1 > maxLen) {
                maxLen = r - l - 1;
                maxSeq = s.substring(l + 1, r);
            }
        }
        return maxSeq;
    }
}

/*Approach 2: DP
isPalindrome(i, j) // whether the substring s[i:j+1] is palindrome
isPalindrome(i, j) = isPalindrome(i + 1, j - 1) and s[i] == s[j]
*/
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) { return ""; }
        int maxLen = 1;
        int start = 0;
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        // base case: (1) every single character is a palindrome (2) take the space as the center, isPalindrome(i, i + 1) = (s[i] == s[i + 1])
        for (int i = 0; i < n; i ++) {
            isPalindrome[i][i] = true;
            if (i < n - 1) {
                isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                if (isPalindrome[i][i + 1]) {
                    maxLen = 2;
                    start = i;
                }
            }
        }
        // iterate by the length of the palindrome
        for (int len = 3; len <= n; len ++) {
            for (int l = 0; l <= n - len; l ++) {
                int r = l + len - 1;
                isPalindrome[l][r] = isPalindrome[l + 1][r - 1] && (s.charAt(l) == s.charAt(r));
                if (isPalindrome[l][r] && (r - l + 1) > maxLen) {
                    maxLen = r - l + 1;
                    start = l;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}