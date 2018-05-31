import java.util.Scanner;

public class Generator {
	public static void main(String[] args) {
		int n = (new Scanner(System.in)).nextInt();
		Solution solution = new Solution();
		System.out.println(solution.racecar(n));
	}
}
