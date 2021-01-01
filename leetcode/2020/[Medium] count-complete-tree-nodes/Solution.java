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
	public int countNodes(TreeNode root) {
		return countNode(root, -1, -1);
	}

	public int countNode(TreeNode root, int left, int right){
		if(root == null) return 0;
		
		if (left == -1) left = getDepth(root, true);
		if (right == -1) right = getDepth(root, false);

		if (left == right) return (1 << left) - 1;

		return countNode(root.left, left - 1, -1) + 1 + countNode(root.right, -1, right - 1);
	}

	public int getDepth(TreeNode root, boolean isLeft){
		if (root == null) return 0;
		return 1 + getDepth(isLeft ? root.left : root.right, isLeft);
	}
}
