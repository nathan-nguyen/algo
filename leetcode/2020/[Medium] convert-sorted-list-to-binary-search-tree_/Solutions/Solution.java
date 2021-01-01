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
		List<Integer> l = new ArrayList<>();
		while (head != null){
			l.add(head.val);
			head = head.next;
		}

		return buildTree(l, 0, l.size() - 1);
	}

	private TreeNode buildTree(List<Integer> l, int from, int to){
		if (from == to) return new TreeNode(l.get(from));
		if (from > to) return null;

		int mid = (from + to) / 2;
		TreeNode root = new TreeNode(l.get(mid));

		root.left = buildTree(l, from , mid - 1);
		root.right = buildTree(l, mid + 1, to);
		return root;
	}
}
