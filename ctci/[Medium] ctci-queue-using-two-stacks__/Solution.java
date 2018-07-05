import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static class TwoStackQueue<T> {
		private Stack<T> inStack = new Stack<>();
		private Stack<T> outStack = new Stack<>();

		public void enqueue(T value){
			inStack.push(value);
		}

		public T peek(){
			if (outStack.isEmpty()) transfer();
			return outStack.peek();
		}

		public T dequeue(){
			if (outStack.isEmpty()) transfer();
			return outStack.pop();
		}

		private void transfer(){
			while (!inStack.isEmpty()) outStack.push(inStack.pop());
		}
	}

	public static void main(String[] args){
		TwoStackQueue<Integer> queue = new TwoStackQueue<>();

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		while (n -- > 0){
			int op = in.nextInt();
			if (op == 1) queue.enqueue(in.nextInt());
			else if (op == 2) queue.dequeue();
			else if (op == 3) System.out.println(queue.peek());
		}
		in.close();
	}
}
