/* 
Use two binary search, to search the row and column seperately
m*n matrix -> O(logm + logn)
*/
class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int row = findRow(mat, target);
        if (row == -1) return false;
        return binarySearch(mat[row], target);
    }
    
    private int findRow(int[][] mat, int target) {
        int ROW = mat.length, COL = mat[0].length;
        int l = 0, r = ROW - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mat[mid][0] > target) {
                r = mid - 1;
            } else {
                if (mat[mid + 1][0] > target) {
                    return mid;
                }
                l = mid + 1;
            }
        }
        return mat[l][0] <= target ? l : -1;
    }
    
    private boolean binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}