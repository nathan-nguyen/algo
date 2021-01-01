/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n == 0) return head;

		int count = 0;
		ListNode cur = head;
		while (cur != null){
			cur = cur.next;
			++count;
		}

		if (n > count) return head;
		n = count - n;


		if (n == 0) return head.next;

		cur = head;

		for (int i = 1; i < n; ++i) cur = cur.next;
		cur.next = cur.next.next;

		return head;
	}
}
