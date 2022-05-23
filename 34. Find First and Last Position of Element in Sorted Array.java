// two pass binary search
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findBound(nums, target, 0, nums.length - 1, true);
        if (left == -1) return new int[]{-1, -1};
        int right = findBound(nums, target, left, nums.length - 1, false);
        return new int[]{left, right};
    }
    public int findBound(int[] nums, int target, int left, int right, boolean isLeft) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else {
                if (isLeft) {
                    if (mid == 0 || nums[mid - 1] < nums[mid]) return mid;
                    right = mid - 1;
                } else {
                    if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) return mid;
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}