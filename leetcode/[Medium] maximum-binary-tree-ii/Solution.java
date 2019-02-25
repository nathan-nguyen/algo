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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null || root.val < val) {
            node.left = root;
            return node;
        }
        traverse(root, node);
        return root;
    }

    private void traverse(TreeNode root, TreeNode node) {
        if (root.right == null) root.right = node;
        else if (root.right.val < node.val) {
            node.left = root.right;
            root.right = node;
        }
        else traverse(root.right, node);
    }
}

