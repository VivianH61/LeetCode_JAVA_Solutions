class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // calculate the total length of the list
        int len = 0;
        ListNode cur = head;
        ListNode lastNode = head;
        while (cur != null) {
            len++;
            lastNode = cur;
            cur = cur.next;
        }
        k %= len;
        if (k == 0) return head;
        ListNode prev = head;
        cur = head.next;
        for (int i = 0; i < len - k - 1; i++) {
            prev = prev.next;
            cur = cur.next;
        }
        prev.next = null;
        lastNode.next = head;
        return cur;
    }
}