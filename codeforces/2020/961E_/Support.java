import java.util.ArrayList;
import java.util.Collections;

public class Support {
	public static void main(String[] args){
		ArrayList<Integer> l = new ArrayList<>();
		l.add(2);
		l.add(5);
		l.add(6);
		l.add(6);
		l.add(7);
		System.out.println(l);
		System.out.println(searchInsert(l, 1));
	}

	public static int searchInsert(ArrayList<Integer> l, int target) {
		int low = 0, high = l.size()-1;
		int result = -1;
		while(low<=high){
			int mid = (low+high)/2;
			if(l.get(mid) == target) {
				result = mid;
				low = mid + 1;
			}
			else if(l.get(mid) > target) high = mid-1;
			else low = mid+1;
		}
		return (result == -1) ? low : result;
	}
}
