/* Use bst properties */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode cur = p.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        
        TreeNode nextNode = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur == p) { return nextNode; }
            if (cur.val < p.val) { cur = cur.right; }
            else {
                nextNode = cur;
                cur = cur.left;
            }
        }
        return nextNode;
    }
}