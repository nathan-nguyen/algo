/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) return null;

        	int count = 1;

		ListNode prev = null;
		ListNode cur = head;
		ListNode next = cur.next;

		while (next != null && count < m){
			prev = cur;
			cur = next;
			next = cur.next;
			++count;
		}

		if (next == null) return head;

		// count == m
		ListNode last = prev;
		ListNode first = cur;	// Node m

		while (next != null && count < n){
			cur.next = prev;
			prev = cur;
			cur = next;
			next = cur.next;
			++count;
		}

		cur.next = prev;
		first.next = next;
		if (last != null) last.next = cur;
		else return cur; 
	
		return head;
	}
}


