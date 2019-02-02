class Solution {
    public String[] spellchecker(String[] wl, String[] q) {
        int n = q.length;
        String[] result = new String[n];

        Set<String> normal = new HashSet<>();
        Map<String, String> caseError = new HashMap<>();
        Map<String, String> error = new HashMap<>();
        
        for (String w: wl) {
            normal.add(w);
            String lowerW = w.toLowerCase();
            if (!caseError.containsKey(lowerW)) caseError.put(lowerW, w);
            String removeVowelW = removeVowel(w);
            if (!error.containsKey(removeVowelW)) error.put(removeVowelW, w);
        }

        for (int i = 0; i < n; ++i) {
            String lowerQ = q[i].toLowerCase();
            if (normal.contains(q[i])) result[i] = q[i];
            else if (caseError.containsKey(lowerQ)) result[i] = caseError.get(lowerQ);
            else {
                String key = removeVowel(q[i]);
                result[i] = error.getOrDefault(key, "");
            }
        }
        return result;
    }

    private String removeVowel(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') c = '-';
            sb.append(c);
        }
        return sb.toString();
    }
}

