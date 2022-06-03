class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(), root, targetSum, ans);
        return ans;
    }
    
    public void backtrack(List<Integer> path, TreeNode root, int required, List<List<Integer>> allPaths) {
        if (root == null) { return; }
        required -= root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && required == 0) {
            allPaths.add(new ArrayList<Integer>(path));
        } else {
            backtrack(path, root.left, required, allPaths);
            backtrack(path, root.right, required, allPaths);
        }
        path.remove(path.size() - 1);
    } 
}