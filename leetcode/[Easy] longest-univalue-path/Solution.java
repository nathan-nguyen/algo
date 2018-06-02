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
	private int max;
	public int longestUnivaluePath(TreeNode root) {
		if (root == null) return 0;

		max = 0;
		lUP(root);

		return max;
	}

	// 0 - normal Max
	// 1 - max with root value
	public int lUP(TreeNode root){
		if (root == null) return 0;

                int left = lUP(root.left);
                int right = lUP(root.right);

		if (root.left != null && root.left.val == root.val) ++left;
		else left = 0;
		if (root.right != null && root.right.val == root.val) ++right;
		else right = 0;

		max = Math.max(max, left + right);
		return Math.max(left, right);
	}
}
