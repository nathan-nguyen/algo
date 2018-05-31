/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode cur = head;
		ListNode next = head.next.next;

		while (next != null && next.next != null){
			cur = cur.next;
			next = next.next.next;
		}

		next = cur.next;
		cur.next = null;
		head = sortList(head);
		next = sortList(next);

		return merge(head, next);
	}

	private ListNode merge (ListNode left, ListNode right){
		if (left == null) return right;
		if (right == null) return left;

		ListNode head;

		if (left.val > right.val) {
			head = right;
			right = right.next;
		}
		else {
			head = left;
			left = left.next;
		}

		ListNode next = head;

		while (left != null && right != null){
			if (left.val > right.val) {
				next.next = right;
				next = next.next;
				right = right.next;
			}
			else {
				next.next = left;
				next = next.next;
				left = left.next;
			}
		}

		if (left == null) next.next = right;
		else if (right == null) next.next = left;

		return head;
	}
}
