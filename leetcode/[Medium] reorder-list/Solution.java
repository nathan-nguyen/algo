/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) return;

		ListNode cur = head;
		ListNode prev = null;
		ListNode next = head;

		// 0-1-null | 1 - null
		while (next != null && next.next != null){
			prev = cur;
			cur = cur.next;
			next = next.next.next;
		}

		if (prev != null) prev.next = null;

		prev = null;
		// Reuse next
		next = cur.next;
		
		while (next != null){
			cur.next = prev;
			prev = cur;
			cur = next;
			next = cur.next;
		}

		cur.next = prev;

		// cur - head
		ListNode left = head.next;
		ListNode right = cur;

		// Reuse cur
		cur = head;

		while (left != null && right != null){
			cur.next = right;
			right = right.next;
			cur = cur.next;
			cur.next = left;
			left = left.next;
			cur = cur.next;
		}

		if (left == null) cur.next = right;
		if (right == null) cur.next = left;
	}
}
