/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;

		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

		RandomListNode newHead = new RandomListNode(head.label);
		map.put(head, newHead);
		RandomListNode cur = head.next;
		RandomListNode newCur = newHead;

		while (cur != null){
			newCur.next = new RandomListNode(cur.label);
			newCur = newCur.next;
			map.put(cur, newCur);
			cur = cur.next;
		}

		cur = head;
		newCur = newHead;

		while (cur != null){
			newCur.random = map.get(cur.random);
			cur = cur.next;
			newCur = newCur.next;
		}

		return newHead;
	}
}
