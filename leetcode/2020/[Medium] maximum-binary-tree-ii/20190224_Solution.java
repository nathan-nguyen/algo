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
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        list.add(val);
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) a[i] = list.get(i);
        return constructMaximumBinaryTree(a);
    }
    
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
    
    private TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    
    private TreeNode construct(int[] a, int l, int r) {
        if (l == r)
            return null;
        int max = max(a, l, r);
        TreeNode root = new TreeNode(a[max]);
        root.left = construct(a, l, max);
        root.right = construct(a, max + 1, r);
        return root;
    }
    
    private int max(int[] a, int l, int r) {
        int max = l;
        for (int i = l; i < r; i++) {
            if (a[max] < a[i]) max = i;
        }
        return max;
    }
}

