import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	public static class Exam {
		int grade;
		int essay;
		
		public Exam (int grade, int essay){
			this.grade = grade;
			this.essay = essay;
		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		long r = in.nextInt();
		long avg = in.nextInt();

		Exam[] examList = new Exam[n];

		// More return 0; -
		long total = 0;

		for (int i = 0; i < n; ++i){
			int grade = in.nextInt();
			int essay = in.nextInt();
			examList[i] = new Exam(grade, essay);
			total += grade;
		}

		if (total >= n * avg) {
			System.out.println(0);
			return;
		}

		Arrays.sort(examList, new Comparator<Exam>(){
			@Override public int compare(Exam o1, Exam o2){
				return Float.compare(o1.essay,o2.essay);
			}
		});
 
		total = n * avg - total;
		long count = 0;

		for (Exam exam : examList){
			if (exam.grade >= r) continue;
			
			if (r - exam.grade >= total){
				count += exam.essay * total;
				System.out.println(count);
				return;
			}

			total -= (r - exam.grade);
			count += exam.essay * (r - exam.grade);
		}

		System.out.println(-1);

	}
}
