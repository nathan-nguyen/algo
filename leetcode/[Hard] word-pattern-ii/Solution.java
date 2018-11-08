class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        return wordPatternMatch(pattern, str, new HashMap<>(), new HashSet<>());
    }

    public boolean wordPatternMatch(String pattern, String str, Map<Character, String> map, Set<String> set){
        if (pattern.length() == 0) return str.length() == 0;
        
        char c = pattern.charAt(0);
        if (map.containsKey(c)) {
            String value = map.get(c);
            if (value.length() > str.length()) return false;
            return value.equals(str.substring(0, value.length())) && wordPatternMatch(pattern.substring(1), str.substring(value.length()), map, set);
        }

        for (int i = 1; i <= str.length(); ++i) {
            String value = str.substring(0, i);
            if (set.contains(value)) continue;
            set.add(value);
            map.put(c, value);
            if (wordPatternMatch(pattern.substring(1), str.substring(i), map, set)) return true;
            map.remove(c);
            set.remove(value);
        }
        return false;
    }
}