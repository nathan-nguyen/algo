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
        public TreeNode pruneTree(TreeNode root) {
                traverseTree(root);
                return root;
        }

        private boolean traverseTree(TreeNode root){
                boolean result = (root.val == 1) ? true : false;
                if (root.left != null) {
                        if (traverseTree(root.left)) result = true;
                        else root.left = null;
                }
                if (root.right != null){
                        if (traverseTree(root.right)) result = true;
                        else root.right = null;
                }
                return result;
        }
}

