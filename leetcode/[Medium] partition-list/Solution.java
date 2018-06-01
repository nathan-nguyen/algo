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
		ListNode small = null;
		ListNode bS = null;
		ListNode greater = null;
		ListNode beginGreater = null;

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
				if (greater == null) {
					greater = cur;
					beginGreater = greater;
				}
				else {
					greater.next = cur;
					greater = greater.next;
				}
			}
			cur = cur.next;
			if (small != null) small.next = null;
                        if (greater != null) greater.next = null;
		}

		if (small == null) return beginGreater;
		else small.next = beginGreater;
		return bS;
	}
}
