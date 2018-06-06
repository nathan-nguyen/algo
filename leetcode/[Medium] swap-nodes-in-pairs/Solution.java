/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode prev = head;
		ListNode cur = head.next;
		ListNode next = cur.next;
		cur.next = head;

		head = cur;
		cur = next;
                
		while (cur != null && cur.next != null){
			prev.next = cur.next;
			next = cur.next.next;
			cur.next.next = cur;
	
			prev = cur;	
			cur = next;
		}

                prev.next = cur;
		return head;
	}
}

