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
	private int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		this.max = Integer.MIN_VALUE;

		maxPath(root);
		return max;
	}

	public int maxPath(TreeNode root){
		if (root == null) return 0;

		int left = Math.max(0, maxPath(root.left));
		int right = Math.max(0, maxPath(root.right));

		max = Math.max(max, left + root.val + right);

		return root.val + Math.max(left,right);
	}
}
