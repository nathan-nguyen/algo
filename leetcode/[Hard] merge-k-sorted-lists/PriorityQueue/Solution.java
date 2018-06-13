/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue((u, v) -> ((ListNode)u).val - ((ListNode)v).val);

		for (ListNode l: lists) if (l != null) pq.add(l);

		if (pq.size() == 0) return null;

		ListNode head = pq.poll();
		ListNode cur = head;
		if (head.next != null) pq.offer(head.next);

		while (pq.size() > 0){
			ListNode node = pq.poll();
			cur.next = node;
			cur = cur.next;
			if (node.next != null) pq.offer(node.next);
		}
		cur.next = null;
		return head;
	}
}
