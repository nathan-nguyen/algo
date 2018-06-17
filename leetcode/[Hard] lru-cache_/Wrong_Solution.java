class LRUCache {
	class Node {
		int val;
		int key;
		Node(int key, int val){ this.key = key; this.val = val; }
		Node prev;
		Node next;
	}

	private HashMap<Integer, Node> map = new HashMap<>();
	private int capacity;
	private int size;
	private Node head;
	private Node tail;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		size = 0;
	}
    
	public int get(int key) {
		if (!map.containsKey(key)) return -1;
		Node node = map.get(key);
		insertTail(node);
		return node.val;
	}
    
	private void insertTail(Node node){
		if (node == tail) return;

		if (node == head) {
			head = node.next;
			tail.next = node;
			node.prev = tail;
			node.next = null;
		}
		else if (head == null) head = node;
		else if (node.prev == null && node.next == null) {
			tail.next = node;
			node.prev = tail;
		}
		else {
			node.prev.next = node.next;
			node.prev = tail;
			node.next = null;
			tail.next = node;
		}
		tail = node;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)){
			Node node = map.get(key);
			node.val = value;
			insertTail(node);
			return;
		}

		++size;
		Node node = new Node(key, value);
		map.put(key, node);
		insertTail(node);
		while (size > capacity) {
			--size;
			removeHead();
		}
	}

	private void removeHead(){
		if (head == null) return;

		map.remove(head.key);

		if (head == tail) head = tail = null;
		else {
			head = head.next;
			head.prev = null;
		}
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
