class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            // corner case: when the subarray is sorted
            if (nums[l] <= nums[r]) return nums[l];
            int mid = (l + r) / 2;
            // if the subarray [l: mid + 1] is sorted, the min must on the right of mid
            if (nums[l] <= nums[mid]) l = mid + 1;
            // if the subarray [l: mid + 1] is not sorted, the min must in this subarray
            else r = mid;
        }
        return nums[l];
    }
}
