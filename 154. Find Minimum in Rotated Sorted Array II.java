class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            if (nums[l] < nums[r]) {
                return nums[l];
            }
            int mid = l + (r - l) / 2;
            // skip the duplicate elements
            if (nums[l] == nums[mid]) {
                l++;
            } else if (nums[l] < nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return Math.min(nums[l], nums[r]);
    }
}