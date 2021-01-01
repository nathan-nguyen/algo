/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> map = new HashMap<>();

        int key = 0;
        while (map.contains(key)) result.add(map.get(key++));
        
        return result;
    }

    private void dfs(int height, TreeNode node, Map<Integer, Integer> map) {
        if (node == null) return;
        if (!map.containsKey(height)) map.put(height, node.val);

        dfs(height + 1, node.right, map);
        dfs(height + 1, node.left, map);
    }
}
