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
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> l = new ArrayList<>();
		zigzagLevelOrder(root, l, 0);
		for (int i = 0; i < l.size(); ++i){
			if (i % 2 == 1) Collections.reverse(l.get(i));
		}
		return l;
	}

	private void zigzagLevelOrder(TreeNode root, List<List<Integer>> l, int depth){
		if (root == null) return;
		if (l.size() == depth) l.add(new ArrayList<>());
		l.get(depth).add(root.val);
		zigzagLevelOrder(root.left, l, depth + 1);
		zigzagLevelOrder(root.right, l, depth + 1);
	}
}
