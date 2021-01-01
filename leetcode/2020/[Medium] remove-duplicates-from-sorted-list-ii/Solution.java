/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode curNode = null, prev = head, cur = head.next;
        head = null;
        if (cur == null || prev.val != cur.val) {
            head = prev;
            curNode = prev;
        }
        while (cur != null) {
            if (cur.val != prev.val && (cur.next == null || cur.val != cur.next.val)) {
                if (head == null) head = cur;
                else curNode.next = cur;
                curNode = cur;
            }
            prev = cur;
            cur = cur.next;
        }
        if (curNode != null) curNode.next = null;
        return head;
    }
}
