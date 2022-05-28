/* two pointers
* zeros and non-zeros
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int nonzeroPtr = 0;
        for (int i = 0; i < len; i ++) {
            if (nums[i] != 0) {
                swap(nums, i, nonzeroPtr++);
            }
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int prev = A[i];
        A[i] = A[j];
        A[j] = prev;
    }
}