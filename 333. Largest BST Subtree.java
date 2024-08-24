/*
subtree
max value in the left subtree < value in parent node < min value in right subtree
Post-order traversal (left -> right -> parent)
The left substree need to tell its parent whether it is BST and the max value in it.
The right substree need to tell its parent whether it is BST and the min value in it.

*/
class NodeVal {
    int min, max, maxSize;
    NodeVal(int min, int max, int maxSize) {
        this.min = min;
        this.max = max;
        this.maxSize = maxSize;
    }
}
class Solution {
    public int largestBSTSubtree(TreeNode root) {
        NodeVal res = largestBSTSubtreeHelper(root);
        return res.maxSize;
    }
    
    public NodeVal largestBSTSubtreeHelper(TreeNode root) {
        if (root == null) {
            return new NodeVal(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeVal left = largestBSTSubtreeHelper(root.left);
        NodeVal right = largestBSTSubtreeHelper(root.right);
        if (root.val > left.max && root.val < right.min) {
            return new NodeVal(Math.min(root.val, left.min), Math.max(root.val, right.max), 1 + left.maxSize + right.maxSize);
        } else {
            return new NodeVal(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
        }
        
    }
}