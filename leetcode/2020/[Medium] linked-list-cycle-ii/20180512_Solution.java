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
    public ListNode detectCycle(ListNode head) {
	if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

	while (true){
		if (fast.next == null || fast.next.next == null) return null;
		fast = fast.next.next;
		slow = slow.next;

		if (fast == slow) {
			if (head == fast) return head;

			fast = head;
			while (true) {
				fast = fast.next;
				slow = slow.next;
				if (fast == slow) return fast;
			}
		}
	}
    }
}

