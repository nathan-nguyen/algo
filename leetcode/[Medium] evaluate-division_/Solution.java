class Solution {
	// The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		HashMap<String, ArrayList<String>> gr = new HashMap<>();
		HashMap<String, Double> ed = new HashMap<>();

		for (int i = 0; i < values.length; ++i){
			String[] eq = equations[i];
			double v = values[i];

			update(gr, ed, equations[i][0], equations[i][1], values[i]);
			update(gr, ed, equations[i][1], equations[i][0], 1 / values[i]);
		}

		double[] result = new double[queries.length];
		for (int i = 0; i < queries.length; ++i){
			if (!gr.containsKey(queries[i][1])) result[i] = -1.0;
			else result[i] = dfs(gr, ed, queries[i][0], queries[i][1], new HashSet<>());
		}
		return result;
	}

	private void update(HashMap<String, ArrayList<String>> gr, HashMap<String, Double> ed, String a, String b, double v){
		ArrayList<String> l;
		if (gr.containsKey(a)) l = gr.get(a);
		else {
			l = new ArrayList<>();
			gr.put(a, l);
		}

		l.add(b);
		ed.put(a + "_" + b, v);
	}

	private double dfs(HashMap<String, ArrayList<String>> gr, HashMap<String, Double> ed, String a, String b, HashSet<String> set){
		if (!gr.containsKey(a)) return -1.0;

		if (a.equals(b)) return 1.0;

		set.add(a);
		ArrayList<String> l = gr.get(a);

		double v;
		for (String next: l){
			if (set.contains(next)) continue;
			double u = dfs(gr, ed, next, b, set);
			if (Double.compare(u, -1.0) != 0) return u * ed.get(a + "_" + next);
		}
		return -1.0;
	}
}
