class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] a: pieces) map.put(a[0], a);

        for (int i = 0; i < arr.length;) {
            if (!map.containsKey(arr[i])) return false;
            int[] v = map.get(arr[i]);
            // Because sum(pieces[i].length) == arr.length
            // Remove map.remove(arr[i]);
            for (int e: v) {
                if (arr[i] != e) return false;
                ++i;
            }
        }

        // Because sum(pieces[i].length) == arr.length
        // return map.size() == 0;
        return true;
    }

}
