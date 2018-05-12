class Solution {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			@Override public int compare(int[] o1, int[] o2){
				if (o1[0] == o2[0]) return Double.compare(o1[1], o2[1]);
				return -Double.compare(o1[0], o2[0]);
			}
		});

		ArrayList<int[]> l = new ArrayList<>();
		for (int[] p : people) l.add(p[1], p);

		for (int i = 0; i < l.size(); ++i) people[i] = l.get(i);
		return people;
	}
}
