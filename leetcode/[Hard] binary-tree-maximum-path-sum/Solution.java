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
	private int max = 0;
	public int maxPathSum(TreeNode root) {
		this.max = Integer.MIN_VALUE;

		maxPath(root);
		return max;
	}

	public int maxPath(TreeNode root){
		if (root == null) return 0;

		int left = maxPath(root.left);
		int right = maxPath(root.right);

		max = Math.max(max, left + root.val + right);
		int returnVal = root.val + Math.max(Math.max(left, right), 0);
		max = Math.max(max, returnVal);

		return returnVal;
	}
}
