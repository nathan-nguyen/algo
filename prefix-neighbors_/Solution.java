import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	// Root -> Node -> Node -> Node(end = true)
	private class Node {
		char c;
		int val;
		Node[] child = new Node[26];

		int chosen;
		int notChosen;	

		public Node(){
		}

		public Node(char c){
			this.c = c;
		}

		public void insert(String s, int val){
			if (s.length() == 0) {
				this.val = val;
				return;
			}

			int index = s.charAt(0) - 'A';
			if (child[index] == null) child[index] = new Node(s.charAt(0));
			
			child[index].insert(s.substring(1, s.length()), val);
		}
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		String[] s = new String[n];

		Node root = new Node();
		for (int i = 0; i < n; ++i) {
			String e = in.next();
			root.insert(e, calVal(e));
		}

		int total = 0;
		for (int i = 0; i < 26; ++i){
			if (root.child[i] == null) continue;
			int[]  result = dfs(root.child[i]);
			System.out.println((char)(i + 'A') + " " + result[0] + " " +  result[1]);
			total += Math.max(result[0], result[1]);	
		}
		System.out.println(total);
	}

	private int calVal(String s){
		int result = 0;
		for (int i = 0; i < s.length(); ++i) result += s.charAt(i);
		return result;
	}

	private int[] dfs(Node n){
		n.chosen = n.val;

		for (int i = 0; i < 26; ++i) {
			if (n.child[i] == null) continue;
			int[] result = dfs(n.child[i]);

			if (n.val > 0) {
				n.chosen += result[1];
				n.notChosen += Math.max(result[1], result[0]);
			}
			else {
				n.chosen += result[0];
				n.notChosen += result[1];
			}
		}
		return new int[]{n.chosen, n.notChosen};
	}
}
