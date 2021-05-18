import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] w, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s: w) map.put(s, map.getOrDefault(s, 0) + 1);

        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
            k,
            (u, v) -> u.getValue() == v.getValue() ? u.getKey().compareTo(v.getKey()) : -Integer.compare(u.getValue(), v.getValue())
        );
        queue.addAll(map.entrySet());

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty() && result.size() < k) result.add(queue.poll().getKey());
        return result;
    }
}
