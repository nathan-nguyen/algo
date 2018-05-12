import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	private static int n;
	private static String[] data;
	private static int prevCol = -1;
	private static ArrayList<Integer> prevList, currList;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		int m = in.nextInt();

		data = new String[n];
		for (int i = 0; i < n; ++i) data[i] = in.next();

		int count = 0;

		for (int i = 0; i < m; ++i){
			if (prevCol == -1){
				if (findFirstCol(i)) {
					prevCol = i;
					prevList = currList;
				}
				else ++count;
			}
			else {
				if (prevList.size() == 0) break;
				if (!findNextCol(i)) ++count;
				else {
					prevCol = i;
					prevList = currList;
				}
			}
		}
		System.out.println(count);
	}

	private static boolean findFirstCol(int col){
		currList = new ArrayList<Integer>();
		for (int i = 1; i < n; ++i){
			char prevC = data[i-1].charAt(col);
			char currC = data[i].charAt(col);

			if (prevC > currC) return false;
			if (prevC == currC){
				if (currList.size() == 0 || currList.get(currList.size() - 1) != i - 1) currList.add(i - 1);
				currList.add(i);
			}
		}
		return true;
	}

	public static boolean findNextCol(int col){
		currList = new ArrayList<>();

		for (int i = 1; i < prevList.size(); ++i){
			int prevIndex = prevList.get(i-1);
			int currIndex = prevList.get(i);
			if (data[currIndex].charAt(prevCol) != data[prevIndex].charAt(prevCol)) continue;

			char prevC = data[prevIndex].charAt(col);
			char currC = data[currIndex].charAt(col);
			if (prevC > currC) return false;

			if (prevC == currC){
				if (currList.size() == 0 || currList.get(currList.size() - 1) != prevIndex) currList.add(prevIndex);
				currList.add(currIndex);
			}
		}

		return true;
	}
}
