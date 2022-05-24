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