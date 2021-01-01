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
	private List<Integer> result = new ArrayList<>();
	public List<Integer> postorderTraversal(TreeNode root) {
		result.clear();

		traverse(root);
		return result;
	}

	private void traverse(TreeNode root){
		if (root == null) return;
		traverse(root.left);
		traverse(root.right);
		result.add(root.val);
	}
}
