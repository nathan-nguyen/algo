/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode partition(ListNode head, int x) {
		if (head == null) return null;

		ListNode cur = head;
		ListNode small = null, bS = null;
		ListNode big = null, bB = null;

		while (cur != null){
			if (cur.val < x){
				if (small == null) {
					small = cur;
					bS  = small;
				}
				else {
					small.next = cur;
					small = small.next;
				}
			}
			else {
				if (big == null) {
					big = cur;
					bB = big;
				}
				else {
					big.next = cur;
					big = big.next;
				}
			}
			cur = cur.next;
		}

		if (big != null) big.next = null;
		if (small == null) return bB;
		else small.next = bB;
		return bS;
	}
}
