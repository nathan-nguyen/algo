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
	public List<TreeNode> generateTrees(int n) {
		if (n == 0) return new ArrayList<>();
		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int l, int r){
		List<TreeNode> list = new ArrayList<>();

		if (l > r) {
			list.add(null);
			return list;
		}

		if (l == r) {
			list.add(new TreeNode(l));
			return list;
		}

		for (int i = l; i <= r; ++i){
			List<TreeNode> leftL = generateTrees(l, i - 1);
			List<TreeNode> rightL = generateTrees(i + 1, r);

			for (TreeNode ln: leftL){
				for (TreeNode rn: rightL){
					TreeNode root = new TreeNode(i);
					root.left = ln;
					root.right = rn;
					list.add(root);
				}
			}
		} 
		return list;
	}
}
