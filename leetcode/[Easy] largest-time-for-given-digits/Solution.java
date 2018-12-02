class Solution {
    public String largestTimeFromDigits(int[] A) {
        List<String> list = new ArrayList<>();
        for (int i: A) list.add(String.valueOf(i));
        List<String> result = permutation(list);
        Collections.sort(result, Collections.reverseOrder());
        for (String s: result) {
            if (Integer.parseInt(s.substring(0, 2)) < 24 && Integer.parseInt(s.substring(2)) < 60) return s.substring(0,2) + ":" + s.substring(2);
        }
        return "";
    }

    private List<String> permutation(List<String> ol) {
        List<String> result = new ArrayList<>();
        if (ol.size() == 0) {
            result.add("");
            return result;
        }   

        for (int i = 0; i < ol.size(); ++i) {
            List<String> nl = new ArrayList<>();
            for (int j = 0; j < ol.size(); ++j) {
                if (i == j) continue;
                else nl.add(ol.get(j));
            }   
            List<String> al = permutation(nl);
            for (String s: al) result.add(ol.get(i) + s); 
        }   
        return result;
    }
}
