class Solution {
    public void flatten(TreeNode root) {
        recursiveFlatten(root);
    }
    // return the rightmost node in the flattened tree
    public TreeNode recursiveFlatten(TreeNode root) {
        // corner case
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode leftTail = recursiveFlatten(root.left);
        TreeNode rightTail = recursiveFlatten(root.right);
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightTail == null) {
            return leftTail;
        }
        return rightTail;
    }
}