/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**Sentinel Head + Predecessor */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(head.val - 1);
        dummyHead.next = head;
        ListNode prev = dummyHead, cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                prev = prev.next;
                cur = cur.next;
                continue;
            }
            while (cur != null && cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            prev.next = cur == null ? null : cur.next;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}