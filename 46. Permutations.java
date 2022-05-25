// Approach: backtracking
class Solution {
  public void backtrack(int n,
                        List<Integer> path,
                        int[] nums,
                        List<List<Integer>> output,
                        int first) {
    // if all integers are used up
    if (first >= n) {
      output.add(new ArrayList<Integer>(path));
        return;
    }
    path.add(nums[first]);
    for (int i = 0; i <= first; i++) {
      Collections.swap(path, first, i);
      backtrack(n, path, nums, output, first + 1);
      Collections.swap(path, first, i);
    }
    path.remove(path.size() - 1);
  }

  public List<List<Integer>> permute(int[] nums) {
    // init output list
    List<List<Integer>> output = new LinkedList();
    int n = nums.length;
    backtrack(n, new ArrayList<Integer>(), nums, output, 0);
    return output;
  }
}


// Optimization: perform swap within the nums, without creating a new array -> less space complexity
class Solution {
    public void backtrack(int n,
                        List<Integer> nums,
                        List<List<Integer>> output,
                        int first) {
        if (first >= n) {
          output.add(new ArrayList<Integer>(nums));
            return;
        }
        for (int i = 0; i <= first; i++) {
          Collections.swap(nums, first, i);
          backtrack(n, nums, output, first + 1);
          Collections.swap(nums, first, i);
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList();
        int n = nums.length;
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        backtrack(n, numsList, output, 0);
        return output;
    }
}