/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
	if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

	while (true){
		if (fast.next == null || fast.next.next == null) return false;
		fast = fast.next.next;
		slow = slow.next;

		if (fast == slow) return true;
	}
    }
}
