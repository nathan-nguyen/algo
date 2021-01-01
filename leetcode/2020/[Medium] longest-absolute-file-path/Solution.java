import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();

		Scanner in = new Scanner(System.in);

		System.out.println(solution.lengthLongestPath(in.nextLine()));
	}

	public int lengthLongestPath(String input) {
		String[] s = input.split("\n");

		int max = 0;
		ArrayList<Integer> dirLength = new ArrayList<>();

		for (int i = 0; i < s.length; ++i){
			if (s[i].length() == 0) continue;

			int l = s[i].replaceAll("\t","").length();

			int curDepth = s[i].length() - l - 1;
			while (dirLength.size() <= curDepth + 1) dirLength.add(0);

			if (s[i].contains(".")){
				max = Math.max(max, (curDepth >= 0 ? dirLength.get(curDepth) : 0) + l);
				continue;
			}

			dirLength.set(curDepth + 1, 1 + (curDepth >= 0 ? dirLength.get(curDepth) : 0) + l);
		}
		return max;
	}
}
