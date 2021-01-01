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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        Stack<TreeNode> main = new Stack<>();
        main.push(root);
        while (!main.isEmpty()) {
            TreeNode node = main.pop();
            if (node == null) continue;
            stack.push(node.val);
            main.push(node.left);
            main.push(node.right);
        }
        Collections.reverse(stack);
        return stack;
    }
}
