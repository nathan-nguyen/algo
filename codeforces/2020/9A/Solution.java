import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();

		int c = 7 - Math.max(a, b);
		switch (c) {
			case 1: System.out.println("1/6"); break;
			case 2: System.out.println("1/3"); break;
			case 3: System.out.println("1/2"); break;
			case 4: System.out.println("2/3"); break;
			case 5: System.out.println("5/6"); break;
			case 6: System.out.println("1/1"); break;
		}
	}
}
