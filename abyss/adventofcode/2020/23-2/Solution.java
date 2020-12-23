import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    class Node {
        int id;
        Node prev;
        Node next;
        Node(int id, Node prev) {
            this.id = id;
            this.prev = prev;
        }
    }

    int MAX = 1000_000;

    private void solve() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int t = in.nextInt();

        Node prev = null;
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= MAX; ++i) {
            int id = i <= s.length() ? (s.charAt(i - 1) - '0') : i;
            Node node = new Node(id, prev);
            if (prev != null) prev.next = node;
            prev = node;
            map.put(id, node);
        }

        Node current = map.get(s.charAt(0) - '0');
        prev.next = current;
        for (int i = 0; i < t; ++i) {
//            printNode(current);
            current = move(current, map);
        }
        Node one = map.get(1);
//        printNode(one);
        System.out.println(one.next.id + " " + one.next.next.id + " " + ((long)one.next.id * one.next.next.id));
    }

    private void printNode(Node head) {
        for (int i = 0; i < MAX; ++i) {
            System.out.print(head.id + " ");
            head = head.next;
        }
        System.out.println();
    }

    private Node move(Node current, Map<Integer, Node> map) {
        Node pickup = current.next;
        current.next = pickup.next.next.next;
        pickup.next.next.next.prev = current;

        // Break the link
        pickup.prev = null;
        pickup.next.next.next = null;

        int destinationId = (current.id + MAX - 2) % MAX + 1;
        while (destinationId == pickup.id || destinationId == pickup.next.id || destinationId == pickup.next.next.id) {
            destinationId = (destinationId + MAX - 2) % MAX + 1;
        }

//        System.out.println("Current Id: " + current.id + " Destination Id: " + destinationId);
        Node destination = map.get(destinationId);

        destination.next.prev = pickup.next.next;
        pickup.next.next.next = destination.next;

        pickup.prev = destination;
        destination.next = pickup;
        return current.next;
    }
}
