import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		long a1 = in.nextLong();
		long b1 = in.nextLong();

		long a2 = in.nextLong();
		long b2 = in.nextLong();

		long area = gcd(a1 * b1, a2 * b2);
		int[] r1 = isValidReduction(a1 * b1 / area);
		int[] r2 = isValidReduction(a2 * b2 / area);

		if (r1[0] == -1 || r2[0] == -1) {
			System.out.println("-1");
			return;
		}

		if (r2[1] > 0){
			if (r1[0] >= r2[1]) r1[0] = r1[0] - r2[1];
			else {
				r2[0] += r2[1] - r1[0];
				r1[0] = 0;
			}
		}
		else {
			if (r1[1] >= r2[0]){
				r1[0] += r1[1] - r2[0];
				r2[0] = 0;
			}
			else r2[0] = r2[0] - r1[1];
		}

		System.out.println(Math.abs(r1[0] - r2[0]) + Math.abs(r1[1] - r2[1]));

		while (r1[1] > 0){
			if (a1 % 3 == 0) a1 = a1 / 3 * 2;
			else if (b1 % 3 == 0) b1 = b1 / 3 * 2;
			else break;
			--r1[1];
			
		}
		while (r1[0] > 0){
			if (a1 % 2 == 0) a1 = a1 / 2;
			else if (b1 % 2 == 0) b1 = b1 / 2;
			else break;
			--r1[0];
		}

		while (r2[1] > 0){ 
                        if (a2 % 3 == 0) a2 = a2 / 3 * 2;
                        else if (b2 % 3 == 0) b2 = b2 / 3 * 2;
                        else break;
                        --r2[1];
                            
                }   
                while (r2[0] > 0){ 
                        if (a2 % 2 == 0) a2 = a2 / 2;
                        else if (b2 % 2 == 0) b2 = b2 / 2;
                        else break;
                        --r2[0];
                }

		System.out.println(a1 + " " + b1 + "\n" + a2 + " " + b2);
	}

	public static int[] isValidReduction(long area){
		int[] count = new int[2];
		while (area % 2 == 0 || area % 3 == 0){
			if (area % 2 == 0) {
				area /= 2;
				++count[0];
			}
			if (area % 3 == 0) {
				area /= 3;
				++count[1];
			}
		}
		return (area == 1) ? count : new int[]{-1};
	}

	public static long gcd(long a, long b){
		if (a < b) return gcd(b, a);
		else if (a % b == 0) return b;
		else return gcd(b, a % b);
	}

	
}
