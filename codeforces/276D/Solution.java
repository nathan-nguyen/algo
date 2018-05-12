import java.util.Scanner;

public class Solution{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		long l = in.nextLong();
		long r = in.nextLong();

		String lS = toBinary(l);
		String lR = toBinary(r);

		boolean change = false;
		long result = 0;
		
		long[] pow = new long[64];
		pow[0] = 1;
		for (int i = 1; i < 64; ++i) pow[i] = 2 * pow[i-1];

		for (int i = 0; i < 64; ++i){
			if (lS.charAt(i) == '0' && lR.charAt(i) == '1') change = true;
			if (change) result += pow[63 - i];
		}
		System.out.println(result);
	}

	private static String toBinary(long n){
		String result = "";

		while (n != 0){
			result = n % 2 + result;
			n /= 2;
		}
		while (result.length() < 64){
			result = "0" + result;
		}
		return result;
	}
}
