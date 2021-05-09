class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        String s = appendArray(arr);
        
        for (int[] a: pieces) {
            if (!s.contains(appendArray(a))) return false;
        }
        return true;
    }

    private String appendArray(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int e: a) sb.append("-" + e + "-");
        return sb.toString();
    }
}
