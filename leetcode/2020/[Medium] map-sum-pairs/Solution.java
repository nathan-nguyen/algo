class MapSum {

	class Node {
		char c;
		Node[] nl = new Node[26];
		int sum, val;

		public int insert(String key, int n, int val){
			if (n == key.length() ){
				int diff = val - this.val;
				this.val = val;
				sum += diff;
				return diff;
			}

			Node child;
			char nc = key.charAt(n);
			if (nl[nc - 'a'] == null) {
				child = new Node();
				nl[nc - 'a'] = child;
				child.c = nc;
			}
			else child = nl[nc - 'a'];

			int diff = child.insert(key, n+1, val);
			sum += diff;
			return diff;
		}

		public int sum(String key, int n){
			if (n == key.length() ) return sum;

			if (nl[key.charAt(n) - 'a'] == null) return 0;
			else return nl[key.charAt(n) - 'a'].sum(key, n + 1);
		}
	}

	private Node root;

	/** Initialize your data structure here. */
	public MapSum() {
        	root = new Node();
	}
    
	public void insert(String key, int val) {
        	root.insert(key, 0, val);
	}
    
	public int sum(String prefix) {
        	return root.sum(prefix, 0);
	}
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
