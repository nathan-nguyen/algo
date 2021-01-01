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

	public int diameterOfBinaryTree(TreeNode root) {
		this.max = 0;

		findDiameter(root);
		return max;
	}

	private int findDiameter(TreeNode root){
		if (root == null) return 0;

		int left = findDiameter(root.left);

		int right = findDiameter(root.right);

		max = Math.max(max, left + right);
		return 1 + Math.max(left, right);
	}
}
