import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		List<Node> list = new ArrayList<>();
		for (int i = 0; i < n; ++i) list.add(new Node(i + 1));

		for (int i = 0; i < n; ++i) {
			int left = in.nextInt() - 1;
			int right = in.nextInt() - 1;

			list.get(i).left = (left >= 0) ? list.get(left) : null;
 			list.get(i).right = (right >= 0) ? list.get(right) : null;
		}

		int s = in.nextInt();
		while (s -- > 0) {
			swap(list.get(0), 1, in.nextInt());
			System.out.println();
		}
	}

	private void swap(Node root, int d, int k) {
		if (root == null) return;

		if (d % k == 0) {
			Node swp = root.left;
			root.left = root.right;
			root.right = swp;
		}

		swap(root.left, d + 1, k);
		System.out.print(root.val + " ");
		swap(root.right, d + 1, k);
		
	}
}
