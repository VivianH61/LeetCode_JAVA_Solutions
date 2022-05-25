/*
if A[i] != B[j]
    subarray(i,j) = 0
if A[i] == B[j] 
    subarray(i, j) = subarray[i - 1][j - 1] + 1
*/
class Solution {
    public int findLength(int[] A, int[] B) {
        int maxLen = 0;
        int[][] maxSubarray = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    maxSubarray[i][j] = maxSubarray[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, maxSubarray[i][j]);
                } else {
                    maxSubarray[i][j] = 0;
                }
            }
        }
        return maxLen;
    }
}