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
	public int rob(TreeNode root) {
		int[] result = robHouse(root);

		return Math.max(result[0], result[1]);
	}

	public int[] robHouse(TreeNode root){
		if (root == null) return new int[]{0, 0};

		//0 - chosen - 1 - not chosen
		int[] result = new int[2];
		int[] left = robHouse(root.left);
		int[] right = robHouse(root.right);

		result[0] = root.val + left[1] + right[1];
		result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return result;
	}
}
