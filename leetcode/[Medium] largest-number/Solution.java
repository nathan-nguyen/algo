class Solution {
	public String largestNumber(int[] nums) {
		if (nums.length == 0) return "";

		String[] sl = new String[nums.length];

		for (int i = 0; i < nums.length; ++i) sl[i] = String.valueOf(nums[i]);

		Arrays.sort(sl, (u, v) -> (v + u).compareTo(u + v));

		if (sl[0].equals("0")) return "0";

		StringBuilder sb = new StringBuilder();
		for (String s: sl) sb.append(s);
		return sb.toString();
	}
}
