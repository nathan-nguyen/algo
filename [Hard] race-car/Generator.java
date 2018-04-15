import java.util.Scanner;

public class Generator {
	public static void main(String[] args) {
		int n = (new Scanner(System.in)).nextInt();
		for (int i = 0; i < n + 1; ++i){
			System.out.println(i);
		}
	}
}
