import java.util.Scanner;

public class Solution {

	public static class Book {
		int id;
		int weight;

		Book next;

		public Book(int id, int weight){
			this.id = id;
			this.weight = weight;
		}		
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		Book[] bookList= new Book[n];
		Book firstBook = null, lastBook = null;

		for (int i = 0; i < n; ++i) {
			bookList[i] = new Book(i, in.nextInt());
		}


		int[] readId = new int[m];
		for (int i = 0; i < m; ++i){
			int id = in.nextInt() - 1;
			readId[i] = id;

			if (firstBook == null) {
				firstBook = bookList[id];
				lastBook = bookList[id];
			}
			else if (bookList[id].next == null) {
				lastBook.next = bookList[id];
				lastBook = bookList[id];
			}
		}

		// firstBook is null?

		int totalWt = 0;
		for (int i = 0; i < m; ++i){
			int target = readId[i];

			if (firstBook.id == target) continue;

			Book trace = firstBook;
			totalWt += firstBook.weight;

			while (trace.next.id != target){
				totalWt += trace.next.weight;
				trace = trace.next;
			}

			Book holdBook = trace.next;

			trace.next = holdBook.next;
			holdBook.next = firstBook;
			firstBook = holdBook;
		}

		System.out.println(totalWt);
	}
}
