class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) { break; }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l + 1 < r && nums[l] == nums[l + 1]) {
                        l ++;
                    }
                    while (r - 1 > l && nums[r] == nums[r - 1]) {
                        r --;
                    }
                    l ++;
                    r --;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l += 1;
                } else {
                    r -= 1;
                }
            }
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i ++;
            }
            i ++;
        } // while (i < nums.length - 2)
        return ans;
    }
}