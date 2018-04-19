/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public int numComponents(ListNode head, int[] G) {
		int[] map = new int[10001];

		int n = 0;
		while (head != null) {
			map[head.val] = n++;
			head = head.next;
                }

		boolean[] connect = new boolean[n];
		int count = 0;

		for (int i = 0; i < G.length; ++i){
			int val = map[G[i]];
			connect[val] = true;

			if ( ! ((val + 1 < n && connect[val+1]) || (val >= 1 && connect[val-1])) ) ++count;
			else if (val >= 1 && connect[val-1] && val + 1 < n && connect[val+1]) --count;
		}
		return count;
	}
}
