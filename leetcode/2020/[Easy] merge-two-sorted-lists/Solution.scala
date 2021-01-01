/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
  def mergeTwoLists(ll1: ListNode, ll2: ListNode): ListNode = {
    if (ll1 == null) ll2
    else if (ll2 == null) ll1
    else {
      var (l1, l2, node) = (ll1, ll2, ListNode(0))
      var head: ListNode = null

      while (l1 != null && l2 != null) {
        if (l1.x < l2.x) {
          node.next = l1;
          l1 = l1.next
        } else {
          node.next = l2
          l2 = l2.next
        }
        node = node.next
        if (head == null) head = node;
      }
      node.next = if (l1 == null) l2 else l1
      head
    }
  }
}

