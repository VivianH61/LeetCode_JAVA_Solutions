/** Binary Search
 * Time: O(nlogn)
 * Space: O(n)
 */
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        int[] prefix_sums = getPrefixSums(nums);
        int minLen = Integer.MAX_VALUE;
        for (int start = 0; start < nums.length; start++) {
            int l = start, r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (prefix_sums[mid + 1] - prefix_sums[start] < s) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (prefix_sums[l + 1] - prefix_sums[start] >= s) {
                minLen = Math.min(minLen, l - start + 1);
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    private int[] getPrefixSums(int[] nums) {
        int[] prefix_sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix_sums[i + 1] = prefix_sums[i] + nums[i];
        }
        return prefix_sums;
    }
}