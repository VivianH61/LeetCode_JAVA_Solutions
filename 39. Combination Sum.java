class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        backtrack(0, target, candidates, new ArrayList<Integer>());
        return ans;
    }
    
    private void backtrack(int start, int required, int[] candidates, List<Integer> path) {
        if (required == 0) {
            ans.add(new ArrayList<>(path));
            return;
        } else if (required < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i ++) {
            path.add(candidates[i]);
            backtrack(i, required - candidates[i], candidates, path);
            path.remove(path.size() - 1);
        }
    } 
}