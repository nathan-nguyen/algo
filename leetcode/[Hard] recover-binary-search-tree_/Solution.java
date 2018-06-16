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
	private TreeNode one, two, prev;

	public void recoverTree(TreeNode root) {
		one = two = null;
		prev = new TreeNode(Integer.MIN_VALUE);

		recoverTreeNode(root);
		one.val ^= two.val;
		two.val ^= one.val;
		one.val ^= two.val;
	}

	private void recoverTreeNode(TreeNode root){
		if (root == null) return;

		recoverTreeNode(root.left);

		if (one == null && prev.val > root.val) one = prev;
		if (one != null && prev.val > root.val) two = root;

		prev = root;

		recoverTreeNode(root.right);
	}
}
