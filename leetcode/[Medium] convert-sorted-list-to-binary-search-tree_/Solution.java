/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return new TreeNode(head.val);

		ListNode prev = null;
		ListNode cur = head;
		ListNode next = head;

		while(next != null && next.next != null){
			prev = cur;
			cur = cur.next;
			next = next.next.next;
		}

		// Reuse variable next
		next = cur.next;
		if (prev != null) prev.next = null;
		cur.next = null;

		TreeNode root = new TreeNode(cur.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(next);

		return root;
	}

}
