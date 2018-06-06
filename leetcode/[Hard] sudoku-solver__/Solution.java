import java.util.HashSet;
import java.util.HashMap;

class Solution {
	public void solveSudoku(char[][] board) {
		HashMap<String, HashSet<Integer>> map = new HashMap<>();

		for (int i = 0; i < 9; ++i){
			map.put("r" + i, createDefaultHashSet());
			map.put("c" + i, createDefaultHashSet());
			for (int j = 0; j < 9; ++j) {
				if (i < 3 && j < 3) map.put("gr" + i + "_" + j, createDefaultHashSet());
				map.put(i + "_" + j, createDefaultHashSet());
			}
		}

		for (int i = 0; i < 9; ++i){
			for (int j = 0; j < 9; ++j){
				if (board[i][j] != '.') remove(i, j, map, board[i][j] - '0');
			}
		}
	
		solve(0, board, map);	
	}

	private boolean solve(int start, char[][] board, HashMap<String, HashSet<Integer>> map){
		for (int i = start; i < 81; ++i){
			int x = i / 9;
			int y = i % 9;
			if (board[x][y] != '.') continue;
			if (!isValid(x, y, map)) continue;

			for (int k = 1; k <= 9; ++k){
				if (!contains(x, y, map, k)) continue;
				board[x][y] = (char)('0' + k);
				if (i == 80) return true;
				
				remove(x, y, map, k);
				if (solve(i + 1, board, map)) return true;
				add(x, y, map, k);
				board[x][y] = '.';
			}
			return false;
		}
		return true;
	}

	private void add(int x, int y, HashMap<String, HashSet<Integer>> map, int val){
		map.get("r" + x).add(val);
		map.get("c" + y).add(val);
		map.get("gr" + (x / 3) + "_" + (y / 3)).add(val);
		map.get(x + "_" + y).add(val);
	}

	private void remove(int x, int y, HashMap<String, HashSet<Integer>> map, int val){
                map.get("r" + x).remove(val);
                map.get("c" + y).remove(val);
                map.get("gr" + (x / 3) + "_" + (y / 3)).remove(val); 
                map.get(x + "_" + y).remove(val);
        }

	private boolean isValid(int x, int y, HashMap<String, HashSet<Integer>> map){
		return map.get("r" + x).size() > 0 && map.get("c" + y).size() > 0 && map.get("gr" + (x / 3) + "_" + (y / 3)).size() > 0 && map.get(x + "_" + y).size() > 0;
	}	

	private boolean contains(int x, int y, HashMap<String, HashSet<Integer>> map, int val){
		return map.get("r" + x).contains(val) && map.get("c" + y).contains(val) && map.get("gr" + (x / 3) + "_" + (y / 3)).contains(val) && map.get(x + "_" + y).contains(val);
	}

	private HashSet<Integer> createDefaultHashSet(){
		HashSet<Integer> set = new HashSet<>();
                for (int k = 1; k <= 9; ++k) set.add(k);
		return set;
	}
}
