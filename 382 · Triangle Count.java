public class Solution {
    /**
     * @param s: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                // use binary search to find the largest nums[k] so that nums[i] + nums[j] > nums[k]
                int l = j + 1, r = len - 1;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (nums[i] + nums[j] > nums[mid]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                if (nums[i] + nums[j] > nums[l]) {
                    count += l - j;
                } else {
                    count += l - j - 1;
                }
            }
        }
        return count;
    }
}