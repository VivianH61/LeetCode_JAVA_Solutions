class Solution {
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        memo[0][0] = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    memo[i + 1][j + 1] = memo[i][j] + 1;
                    ans = Math.max(ans, memo[i + 1][j + 1]);
                }
            }
        }
        return ans;
    }
}