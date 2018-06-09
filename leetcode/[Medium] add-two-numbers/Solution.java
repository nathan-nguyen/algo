/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		int val = l1.val + l2.val;
		ListNode head = new ListNode((val % 10));
		ListNode cur = head;
		l1 = l1.next;
		l2 = l2.next;

		while (l1 != null || l2 != null){
			int v1 = (l1 == null) ? 0 : l1.val;
			int v2 = (l2 == null) ? 0 : l2.val;

			val = v1 + v2 + val / 10;
			cur.next = new ListNode(val % 10);
			cur = cur.next;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}

		if (val > 9) cur.next = new ListNode(1);

		return head;
	}
}
