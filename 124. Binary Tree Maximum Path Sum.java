class Solution {
    int maxPath;
    public int maxPathSum(TreeNode root) {
        this.maxPath = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return this.maxPath;
    }
    
    public int maxPathSumHelper(TreeNode root) {
        if (root == null) { return 0; }
        int left = Math.max(maxPathSumHelper(root.left), 0);
        int right = Math.max(maxPathSumHelper(root.right), 0);
        int total = root.val + left + right;
        this.maxPath = Math.max(this.maxPath, total);
        return root.val + Math.max(left, right);
    }
}