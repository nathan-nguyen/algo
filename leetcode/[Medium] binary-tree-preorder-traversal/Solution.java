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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(list, root);
        return list;
    }
    
    private void traverse(List<Integer> list, TreeNode node) {
        if (node == null) return;
        list.add(node.val);
        traverse(list, node.left);
        traverse(list, node.right);
    }
}

