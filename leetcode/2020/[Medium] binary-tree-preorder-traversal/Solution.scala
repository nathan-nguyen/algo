/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def preorderTraversal(root: TreeNode): List[Int] = root match {
        case null => Nil
        case _ => root.value :: preorderTraversal(root.left) ::: preorderTraversal(root.right)
    }
}

