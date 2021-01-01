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
	public int longestUnivaluePath(TreeNode root) {
		if (root == null) return 0;
		return lUP(root)[0] - 1;
	}

	// 0 - normal Max
	// 1 - max with root value
	public int[] lUP(TreeNode root){
		if (root == null) return new int[]{0, 0};

                int[] left = lUP(root.left);
                int[] right = lUP(root.right);

		int[] max = new int[2];
		max[0] = Math.max(left[0], right[0]);

		int maxRootPath = 1;
		max[1] = 1;
		if (root.left != null && root.left.val == root.val) {
			maxRootPath += left[1];
			max[1] = Math.max(max[1], 1 + left[1]);
		}
		if (root.right != null && root.right.val == root.val) {
			maxRootPath += right[1];
			max[1] = Math.max(max[1], 1 + right[1]);
		}

		max[0] = Math.max(max[0], maxRootPath);
		return max;
	}
}
