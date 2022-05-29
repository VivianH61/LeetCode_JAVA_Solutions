/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/* Aproach: use the leftmost node, without using queue
case 1: establish the next ptr between the two children of a given node
          node.left.next = node.right
case 2: establish the next ptr between two nodes with different parents
        for these two nodes, their parents are consecutive in the previous level
        
When we go over the nodes from a particular level, their next ptrs are already established, as a linked list. So, we only need to keep the left most node of each level, as the head of the linkedlist.*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node leftmost = root;
        while (leftmost.left != null) {
            // Iterate the linked list starting from the head
            Node head = leftmost;
            leftmost = leftmost.left;
            while (head != null) {
                // case 1
                head.left.next = head.right;
                // case 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                } 
                head = head.next;
            }
        }
        return root;
    }
}