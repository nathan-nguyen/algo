class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> failedSet = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (String e: wordDict) set.add(e);
        return wordBreak(s, set, failedSet);
    }

    private boolean wordBreak(String s, Set<String> set, Set<String> failedSet) {
        if (s.length() == 0 || set.contains(s)) return true;
        if (failedSet.contains(s)) return false;

        for (int i = 1; i < s.length(); ++i ) {
            if (set.contains(s.substring(0, i)) && wordBreak(s.substring(i), set, failedSet)) return true;
        }
        failedSet.add(s);
        return false; 
    }
}
