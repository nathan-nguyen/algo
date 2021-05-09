class Solution {
    class Node {
        int val;
        Map<Integer, Node> map = new HashMap<>();
        
        Node(int val) {
            this.val = val;
        }

        private void add(int index, int[] a) {
            if (index >= a.length) return;
            int next = a[index];
            Node nextNode = map.getOrDefault(next, new Node(next));
            map.put(next, nextNode);
            nextNode.add(index + 1, a);
        }

        private boolean contains(int index, List<Integer> a) {
            if (index >= a.size()) return true;
            int next = a.get(index);
            return map.containsKey(next) && map.get(next).contains(index + 1, a);
        }
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
       Node root = new Node(0);
       Set<String> set = new HashSet<>();
       for (int[] a: pieces) {
           root.add(0, a);
           StringBuilder sb = new StringBuilder();
           for (int e: a) sb.append("-" + e);
           set.add(sb.toString());
       }

       return backtrack(root, arr, 0, set);
    }

    private boolean backtrack(Node root, int[] a, int index, Set<String> set) {
        if (index == a.length && set.size() == 0) return true;

        List<Integer> args = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < a.length; ++i) {
            args.add(a[i]);
            sb.append("-" + a[i]);
            if (!root.contains(0, args)) return false;
            String s = sb.toString();
            if (!set.contains(s)) continue;
            set.remove(s);
            if (backtrack(root, a, i + 1, set)) return true;
            set.add(s);
        }
        return false;
    }
}

