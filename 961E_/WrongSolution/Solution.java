import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(solution.solve());
	}

	private long solve(){
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; ++i) a[i] = in.nextInt();

		if (n == 1) return 0;

		long result = 0;

		ArrayList<Integer> l = new ArrayList<>();

		for (int i = 0; i < n; ++i){
			int index = searchInsert(l, (i + 1));
			result += (l.size() - index);
			System.out.println((i+1) + " " + index + " " + result);
			l.add(searchInsert(l, a[i]), a[i]);
			System.out.println(l);System.out.println();
		}

		return result;
	}

	public int searchInsert(ArrayList<Integer> l, int target) {
                int low = 0, high = l.size()-1;
                int result = -1;
                while(low<=high){
                        int mid = (low+high)/2;
                        if(l.get(mid) == target) {
                                result = mid;
                                high = mid - 1;
                        }
                        else if(l.get(mid) > target) high = mid-1;
                        else low = mid+1;
                }
                return (result == -1) ? low : result;
        }
}
