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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null) return null;
        if (original == target) return cloned;
        TreeNode searchLeft = getTargetCopy(original.left, cloned.left, target);
        if (searchLeft != null) return searchLeft;
        return getTargetCopy(original.right, cloned.right, target);
    }
}
