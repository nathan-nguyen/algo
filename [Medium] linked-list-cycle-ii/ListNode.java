public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}

	public static void main(String[] args){
		Solution solution = new Solution();
		ListNode head = new ListNode(0);
		ListNode next = head;
		ListNode result = null;
		for (int i = 1; i <= 9; ++i){
			next.next = new ListNode(i);
			next = next.next;
			if (i == 6) result = next;
		}
		next.next = result;
		System.out.println(solution.detectCycle(head).val);
		
	}
}
