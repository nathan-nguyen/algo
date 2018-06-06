import java.util.Arrays;

public class Generator {
	public static void main(String[] args){
		Generator generator = new Generator();
		generator.generate();
	}

	private void generate(){
		int[][] a = new int[3][3];

		boolean[] chosen = new boolean[10];
		for (int x = 1; x <= 9; ++x){
			chosen[x] = true;
			for (int y = 1; y <= 9; ++y){
				if (chosen[y]) continue;
				chosen[y] = true;
				for (int z = 1; z <= 9; ++z){
					if (chosen[z]) continue;
					chosen[z] = true;
					for (int t = 1; t <= 9; ++t){
						if (chosen[t]) continue;
						chosen[t] = true;
						a[0][0] = x;
						a[0][1] = y;
						a[1][0] = z;
						a[1][1] = t;
						finish(a, Arrays.copyOf(chosen, 10));
						a[0][0] = 0;
						a[0][1] = 0;
						a[1][0] = 0;
						a[1][1] = 0;
						chosen[t] = false;
					}
					chosen[z] = false;
				}
				chosen[y] = false;
			}
			chosen[x] = false;
		}
	}

	private void finish(int[][] a, boolean[] chosen){
		a[0][2] = 15 - a[0][0] - a[0][1];
		if (a[0][2] < 1 || a[0][2] > 9 || chosen[a[0][2]]) return;
		chosen[a[0][2]] = true;

		a[1][2] = 15 - a[1][0] - a[1][1];
		if (a[1][2] < 1 || a[1][2] > 9 || chosen[a[1][2]]) return;

		a[2][2] = 15 - a[0][2] - a[1][2];
		if (a[2][2] < 1 || a[2][2] > 9 || chosen[a[2][2]] || a[0][0] + a[1][1] + a[2][2] != 15) return;

		a[2][1] = 15 - a[0][1] - a[1][1];
		if (a[2][1] < 1 || a[2][1] > 9 || chosen[a[2][1]]) return;

		a[2][0] = 15 - a[0][0] - a[1][0];
		if (a[2][0] < 1 || a[2][0] > 9 || chosen[a[2][0]] || a[2][0] + a[1][1] + a[0][2] != 15 || a[2][0] + a[2][1] + a[2][2] != 15) return;

		for (int i = 0; i < 3; ++i){
			for (int j = 0; j < 3; ++j) System.out.print(a[i][j] + " ");
			System.out.println();
		}

		System.out.println();
	}
}
