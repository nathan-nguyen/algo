import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
	static class Vertex{
		int hasCat;
		HashSet<Vertex> neighbor;
		int parentCatNo;
		boolean isVisited = false;

		public Vertex(int hasCat){
			this.hasCat = hasCat;
			this.neighbor = new HashSet<>();
			parentCatNo = 0;
		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		ArrayList<Vertex> vList = new ArrayList<>();
		for (int i = 0; i < n; ++i) vList.add(new Vertex(in.nextInt()));

		for (int i = 0; i < n - 1; ++i){
			int left = in.nextInt();
			int right = in.nextInt();
			vList.get(left-1).neighbor.add(vList.get(right-1));
			vList.get(right-1).neighbor.add(vList.get(left-1));
		}

		ArrayList<Vertex> queue = new ArrayList<>();
		queue.add(vList.get(0));

		int count = 0;
		while (queue.size() > 0){
			Vertex v = queue.remove(0);
			v.isVisited = true;
			int parentCatNo = (v.hasCat > 0) ? v.parentCatNo + v.hasCat : 0;
			if (parentCatNo > m) continue;

			int localCount = 0;
			for (Vertex neighbor: v.neighbor){
				if (!neighbor.isVisited){
					++localCount;
					queue.add(neighbor);
					neighbor.parentCatNo = parentCatNo;
				}
			}
			if (localCount == 0) ++count;
		}

		System.out.println(count);
	}
}
