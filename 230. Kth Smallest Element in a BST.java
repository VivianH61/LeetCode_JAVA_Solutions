/* 
*interative inorder traversal with a stack 
* Time: O(H + k); H is the height of the tree, since firstly we need to go down to a leaf
* Space: O(H);
*/
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) { return root.val; }
            root = root.right;
        }
        return -1;
    }
}