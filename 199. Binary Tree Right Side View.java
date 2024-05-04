/* BFS with one queue + level size measurement */
class Solution {    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList();
        if (root == null) { return rightSide; }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode node = q.poll();
                if (i == qSize - 1) {
                    rightSide.add(node.val);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return rightSide;
    }
}

/* Recursive DFS */
class Solution {
    List<Integer> rightSide = new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) { return rightSide; }
        rightSideViewHelper(root, 0);
        return rightSide;
    }
    
    public void rightSideViewHelper(TreeNode root, int level) {
        if (level == rightSide.size()) {
            rightSide.add(root.val);
        }
        if (root.right != null) {
            rightSideViewHelper(root.right, level + 1);
        }
        if (root.left != null) {
            rightSideViewHelper(root.left, level + 1);
        }
    }
}