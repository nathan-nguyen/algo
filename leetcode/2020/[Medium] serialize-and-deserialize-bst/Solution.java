/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) result.append("-null");
            else {
                result.append("-" + node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] sList = data.split("-");
        if (sList[1].equals("null")) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(sList[1]));
        queue.add(root);

        for (int i = 2; i < sList.length; i+=2) {
            TreeNode node = queue.poll();
            if (!sList[i].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(sList[i]));
                node.left = leftNode;
                queue.offer(leftNode);
            }
            if (!sList[i+1].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(sList[i+1]));
                node.right = rightNode;
                queue.offer(rightNode);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

