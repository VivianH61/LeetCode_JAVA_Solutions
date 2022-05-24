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