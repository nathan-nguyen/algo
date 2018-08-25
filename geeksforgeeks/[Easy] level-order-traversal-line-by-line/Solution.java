import java.util.LinkedList;
import java.util.List;

public class Solution {
	class Node {
		int val;
		Node left;
		Node right;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve(null);
	}

	private void solve(Node root) {
		if (root == null) return;

		List<Node> level = new LinkedList<>();
		level.add(root);

		while(level.size() > 0) {
			List<Node> nextLevel = new LinkedList<>();
			for (Node node: level) {
				System.out.print(node.val + " ");
				if (node.left != null) nextLevel.add(node.left);
				if (node.right != null) nextLevel.add(node.right);
			}
			System.out.println();
			level = nextLevel;
		}
	}
}
