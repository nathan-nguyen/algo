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
    public void recoverTree(TreeNode root) {
        recoverTree(root, null, null);
        recoverTree(root, null, null);
    }
    
    private void recoverTree(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return;
        if (min != null && root.val < min.val) swap(root, min);
        if (max != null && root.val > max.val) swap(root, max);
        recoverTree(root.left, min, root);
        recoverTree(root.right, root, max);
        if (min != null && root.val < min.val) swap(root, min);
        if (max != null && root.val > max.val) swap(root, max);
    }

    private void swap(TreeNode nodeOne, TreeNode nodeTwo) {
        nodeOne.val ^= nodeTwo.val;
        nodeTwo.val ^= nodeOne.val;
        nodeOne.val ^= nodeTwo.val;
    }
}
