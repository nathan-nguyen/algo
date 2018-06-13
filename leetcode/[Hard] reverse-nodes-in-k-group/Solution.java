/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k < 2 || head == null) return head;

		int count = 1;
		ListNode cur = head.next;
		ListNode prev = head;
		while (cur != null && count < k){
			++count;
			cur = cur.next;
			prev = prev.next;
		}
		if (count < k) return head;
		prev.next = null;
		reverse(head, prev);
		head.next = reverseKGroup(cur, k);

		return prev;
	}

	private void reverse(ListNode head, ListNode end){
		ListNode prev = head;
		ListNode cur = head.next;
		head.next = null;

		ListNode next;
		while (cur != null){
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
	}
}
