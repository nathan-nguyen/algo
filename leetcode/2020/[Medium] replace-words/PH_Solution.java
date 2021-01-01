class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Set<String> set = new HashSet<>();
        for (String s: dict) set.add(s);

        String[] w = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s: w) {
            for (int i = 0; i < s.length(); ++i) {
                sb.append(s.charAt(i));
                if (set.contains(s.substring(0, i + 1))) break;
            }
            sb.append(' ');
        }

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
