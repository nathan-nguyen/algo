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
	public void flatten(TreeNode root) {
		if (root == null) return;
		flattenTree(root);
	}

	private TreeNode flattenTree(TreeNode root){
		if (root.left == null && root.right == null) return root;

		else if (root.left == null) return flattenTree(root.right);

		TreeNode right = root.right;
		root.right = root.left;
		root.left = null;

		if (right == null) return flattenTree(root.right);
		else {
			flattenTree(root.right).right = right;
			return flattenTree(right);
		}
	}
}

