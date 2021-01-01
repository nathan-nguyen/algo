class Solution {
    public int[] deckRevealedIncreasing(int[] d) {
        if (d.length == 0) return new int[0];
        int n = d.length;

        Arrays.sort(d);
        int[] result = new int[n];
        int count = 0;

        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < n; ++i) p.add(i);

        while (count < n) {
            List<Integer> np = new ArrayList<>();
            for (int i = 0; i < p.size(); i++) {
                if (i % 2 == 0) result[p.get(i)] = d[count++];
                else np.add(p.get(i));
            }
            if (np.size() == 0) break;
            if (p.size() % 2 == 0) p = np;  // LOLOLOLOLOL
            else {
                p.clear();
                for (int i = 1; i < np.size(); ++i) p.add(np.get(i));
                p.add(np.get(0));
            }
        }
        return result;
    }
}

