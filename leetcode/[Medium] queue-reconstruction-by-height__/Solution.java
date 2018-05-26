class Solution {
	public int[][] reconstructQueue(int[][] p) {
		Arrays.sort(p, new Comparator<int[]>(){
			@Override public int compare(int[] o1, int[] o2){
				if (o1[0] == o2[0]) return Double.compare(o1[1], o2[1]);
				return -Double.compare(o1[0], o2[0]);
			}
		});

		ArrayList<int[]> l = new ArrayList<>();

		for (int[] e: p) l.add(e[1], e);

		int[][] result = new int[l.size()][2];

		for (int i = 0; i < l.size(); ++i) result[i] = l.get(i);

		return result;
	}
}
