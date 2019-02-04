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
    class Node {
        Node left;
        Node right;
        Node parent;
        int degree;
        int singleChild;
        boolean status;

        Node(Node parent) {
            this.parent = parent;
        }

        void updateDegree() {
            this.degree = ((parent == null) ? 0 : 1) + ((left == null) ? 0 : 1) + ((right == null) ? 0 : 1);
        }

        void updateSingleChild() {
            this.singleChild = ((parent == null) ? 0 : 1) + ((left == null) ? 0 : 1) + ((right == null) ? 0 : 1);
        }

        void removeChild() {
            if (parent != null) parent.removeThis();
            if (left != null) left.removeThis();
            if (right != null) right.removeThis();
        }

        void removeThis() {
            status = true;
            if (parent != null) parent.removeChild(this);
            if (left != null) left.removeChild(this);
            if (right != null) right.removeChild(this);
        }

        void removeChild(Node node) {
            if (parent == node) parent = null;
            else if (left == node) left = null;
            else if (right == node) right = null;
            updateDegree();
            updateSingleChild();
        }
    }

    class Wrapper {
        Node node;
        int singleChild;

        Wrapper(Node node, int singleChild) {
            this.node = node;
            this.singleChild = singleChild;
        }
    }

    public int minCameraCover(TreeNode root) {
        List<Node> nodeList = new ArrayList<>();
        traverseTree(null, root, nodeList);
        for (Node node: nodeList) node.updateSingleChild();
        int count = 0;

        Queue<Wrapper> pq = new PriorityQueue<>((u, v) -> Integer.compare(v.singleChild, u.singleChild));
        for (Node node: nodeList) pq.offer(new Wrapper(node, node.singleChild));

        while (pq.size() > 0) {
            Wrapper w = pq.poll();
            if (w.node.status) continue;
            if (w.node.singleChild != w.singleChild) {
                w.singleChild = w.node.singleChild;
                pq.offer(w);
            }
            else {
                ++count;
                w.node.removeChild();
                w.node.removeThis(); 
            }
        }
        return count;
    }

    private Node traverseTree(Node parent, TreeNode root, List<Node> nodeList) {
        if (root == null) return null;
        Node node = new Node(parent);
        node.left = traverseTree(node, root.left, nodeList);
        node.right = traverseTree(node, root.right, nodeList);
        node.updateDegree();
        nodeList.add(node);
        return node;
    }
}
