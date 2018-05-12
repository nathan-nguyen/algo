class Solution {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		int index = Arrays.binarySearch(arr, x);
		
		index = (index >= 0) ? index : -index - 1;

		int i = index - 1;
		int j = index;

		List<Integer> l = new ArrayList<>();
		while (l.size() < k){
			if (i == -1) l.add(arr[j++]);
			else if (j == arr.length) l.add(0, arr[i--]);
			else if (x - arr[i] <= arr[j] - x) l.add(0, arr[i--]);
			else l.add(arr[j++]);
		}
		return l;
	}
}

