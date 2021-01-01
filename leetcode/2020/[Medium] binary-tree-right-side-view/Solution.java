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
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0) {
            result.add(queue.peek().val);

            Queue<TreeNode> nextQueue = new LinkedList<>();
            for (TreeNode node: queue) {
                if (node.right != null) nextQueue.offer(node.right);
                if (node.left != null) nextQueue.offer(node.left);
            }
            queue = nextQueue;
        }
        return result;
    }
}
