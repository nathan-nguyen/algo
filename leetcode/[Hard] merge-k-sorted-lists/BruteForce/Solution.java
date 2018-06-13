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
		List<ListNode> l = new ArrayList<>();

		for (ListNode ln: lists) {
			while (ln != null) {
				l.add(ln);
				ln = ln.next;
			}
		}

		if (l.size() == 0) return null;

		l.sort((u, v) -> u.val - v.val);

		ListNode head = l.get(0);
		ListNode cur = head;

		for (int i = 1; i < l.size(); ++i){
			cur.next = l.get(i);
			cur = cur.next;
		}
		cur.next = null;

		return head;
	}
}

