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
    public boolean flipEquiv(TreeNode r1, TreeNode r2) {
        return convert(r1).equals(convert(r2));
    }

    private String convert(TreeNode root) {
        if (root == null) return "null-";
        if (root.left == null || (root.right != null && root.left.val > root.right.val)){
            TreeNode swap = root.left;
            root.left = root.right;
            root.right = swap;
        }
        return root.val + "-" + convert(root.left) + "-" + convert(root.right) + "-";
    }
}
