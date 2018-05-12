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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> l = new ArrayList<>();
            
        if (root == null) return l;
        
        if (root.val == sum && root.left == null && root.right == null) {
                List<Integer> cl = new ArrayList<>();
                cl.add(root.val);
                l.add(cl);
                return l;
        }
            
        for (List<Integer> cl : pathSum(root.left, sum - root.val)){
                cl.add(0,root.val);
                l.add(cl);
        }
        for (List<Integer> cl : pathSum(root.right, sum - root.val)){
                cl.add(0, root.val);
                l.add(cl);
        }
        return l;
    }
}

