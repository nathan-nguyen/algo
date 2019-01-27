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
    
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (queue.size() > 0) {
            Queue<TreeNode> nextQueue = new LinkedList<>();
            while (queue.size() > 0) {
                TreeNode next = queue.poll();
                if (next.left == null) return next.right == null && isNoneChild(queue) && isNoneChild(nextQueue);
                nextQueue.add(next.left);
                if (next.right == null) return isNoneChild(queue) && isNoneChild(nextQueue);
                nextQueue.add(next.right);
            }
            queue = nextQueue;
        }
        return true;
    }

    private boolean isNoneChild(Queue<TreeNode> queue) {
        for (TreeNode node: queue) {
            if (node.left != null || node.right != null) return false;
        }
        return true;
    }

}
