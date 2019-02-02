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
    private int value = 0;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (value == 0) value = root.val;
        return root.val == value && isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}

