class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int count = 0;
        for (int i = 0; i < (n + 1) / 2; i++) {
            if (i == n - i - 1) {
                mat[i][i] = ++count;
                break;
            }
            for (int y = i; y < n - i; y++) {
                mat[i][y] = ++count;
            }
            for (int x = i + 1; x < n - i - 1; x++) {
                mat[x][n - i- 1] = ++count;
            }
            for (int y = n - i - 1; y >= i; y--) {
                mat[n - i - 1][y] = ++count;
            }
            for (int x = n - i - 2; x >= i + 1; x--) {
                mat[x][i] = ++count;
            }
        }
        return mat;
    }
}