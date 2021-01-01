/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		List<TreeNode> l = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			l.add(node);
			if (node == null) continue;
			queue.add(node.left);
			queue.add(node.right);
		}

		StringBuilder sb = new StringBuilder();
		for (TreeNode node: l){
			if (sb.length() > 0) sb.append("_");
			if (node == null) sb.append("null");
			else sb.append(node.val);
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.length() == 0) return null;

		String[] a = data.split("_");
		int n = a.length;

		TreeNode[] t = new TreeNode[n];
		
		for (int i = 0; i < n; ++i) t[i] = getNode(a[i]);

		int start = 0, end = 1;
		while (end < n){
			while (t[start] == null) ++start;
			t[start].left = t[end++];
			if (end >= n) break;
			t[start++].right = t[end++];
		}
		return t[0];
	}

	private TreeNode getNode(String s){
		if (s.equals("null")) return null;

		return new TreeNode(Integer.parseInt(s));
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
