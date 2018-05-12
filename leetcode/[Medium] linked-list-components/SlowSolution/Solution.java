/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public int numComponents(ListNode head, int[] oldG) {
		if (oldG.length == 0) return 0;

		Integer[] G = new Integer[oldG.length];

		for (int i = 0; i < oldG.length; ++i) G[i] = oldG[i];

		int count = 0;
		int[] index = new int[10000];

		for (int i = 0; i < 10000; ++i) index[i] = -1;

		while (head != null) {
			index[head.val] = count++;
			head = head.next;
		}

		Arrays.sort(G, new Comparator<Integer>(){
			@Override public int compare(Integer o1, Integer o2){
				if (index[o1] == index[o2]) return 0;
				return (index[o1] > index[o2]) ? 1 : -1;
			}
		});

		// G is subset of all values in the linkedlist
		count = 1;
		int min = index[G[0]] - 1;
		int max = index[G[0]] + 1;
		for (int i = 1; i < G.length; ++i){
			int order = index[G[i]];
			if (order == min) min = order - 1;
			else if (order == max) max = order + 1;
			else {
				++count;
				min = index[G[i]] - 1;
				max = index[G[i]] + 1;
			}
		}

		return count;
	}
}
