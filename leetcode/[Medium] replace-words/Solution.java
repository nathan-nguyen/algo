class Solution {
    public class Node {
        char c;
        Node[] children = new Node[26];
        boolean isCompleted;

        Node(char c) {
            this.c = c;
        }

        void addNode(String s) {
            int index = s.charAt(0) - 'a';
            if (children[index] == null) children[index] = new Node(s.charAt(0));

            // Add this to improve performance
            // if (children[index].isCompleted) return;

            if (s.length() == 1) children[index].isCompleted = true;
            else children[index].addNode(s.substring(1));
        }
        
        int search(String s, int p) {
            assert p <= s.length() : "Invalid value: s = " + s + " - p = " + p;
            if (p == s.length()) return s.length();

            int index = s.charAt(p) - 'a';
            if (children[index] == null) return s.length();

            // Return p + 1 because of substring [0, p]
            if (children[index].isCompleted) return p + 1;
            return children[index].search(s, p + 1);
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        Node root = new Node('X');
        for (String s: dict) root.addNode(s);

        String[] w = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String s: w) {
            int p = root.search(s, 0);
            result.append(s.substring(0, p));
            result.append(' ');
        }
        result.setLength(result.length() - 1);
        return result.toString();
    }
}

