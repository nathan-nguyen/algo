class Solution {
	public List<String> restoreIpAddresses(String s) {
		if (s.length() < 4 || s.length() > 12) return new ArrayList<>();

		return restoreIpAddresses(s, 3);
        }

	public List<String> restoreIpAddresses(String s, int dot){
		List<String> result = new ArrayList<>();

		if (s.length() <= dot || s.length() > 3 * (dot + 1)) return result;
		if (dot == 0) {
			if (s.length() > 0 && Integer.parseInt(s) > 255) return result;
			if (s.length() > 1 && s.charAt(0) == '0') return result;
			result.add(s);
			return result;
		}

		if (s.charAt(0) == '0') {
			List<String> tail = restoreIpAddresses(s.substring(1, s.length()), dot - 1);
			for (String s1: tail) result.add("0." + s1);
			return result;
		}


		for (int i = 0; i < 3 && i < s.length(); ++i){
			String s1 = s.substring(0, i + 1);
			if (Integer.parseInt(s1) > 255) break;

			for (String s2: restoreIpAddresses(s.substring(i + 1, s.length()), dot - 1)) result.add(s1 + "." + s2);
		}
		return result;
	}
}
