class Solution {
	/** No division by zero and no contradiction - All values are positive
	 */
	
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		HashMap<String, List<String>> nodeMap = new HashMap<>();
		HashMap<String, Double> edgeMap = new HashMap<>();

		for (int i = 0; i < equations.length; ++i) {
			updateMap(equations[i][0], equations[i][1], values[i], nodeMap, edgeMap);
			updateMap(equations[i][1], equations[i][0], 1 / values[i], nodeMap, edgeMap);
		}

		double[] result = new double[queries.length];
		for (int i = 0; i < queries.length; ++i) {
			result[i] = dfs(queries[i][0], queries[i][1], nodeMap, edgeMap, new HashSet<>());
		}
		return result;
	}

	private double dfs(String a, String b, HashMap<String, List<String>> nodeMap, HashMap<String, Double> edgeMap, HashSet<String> set) {
		if (!nodeMap.containsKey(a) || set.contains(a)) return -1;
		if (a.equals(b)) return 1;

		set.add(a);
		for (String c: nodeMap.get(a)) {
			double result = dfs(c, b, nodeMap, edgeMap, set);
			if (result > 0) return result * edgeMap.get(a + "_" + c);
		}

		return -1;
	}

	private void updateMap(String a, String b, double value, HashMap<String, List<String>> nodeMap, HashMap<String, Double> edgeMap) {
		List<String> neighborList = nodeMap.getOrDefault(a, new ArrayList<>());
		neighborList.add(b);
		nodeMap.put(a, neighborList);
		edgeMap.put(a + "_" + b, value);
	}
}
