import java.util.HashMap;
import java.util.HashSet;

class Solution {

	public static void main(String[] args){
		Solution solution = new Solution();
		String p = "Bob hit a ball.,;?!' the hit BALL flew far after it was hit.";
		String[] banned = new String[]{"hit"};
		System.out.println(solution.mostCommonWord(p, banned));
	}

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] wl = paragraph.split(" ");

	HashMap<String, Integer> map = new HashMap<>();
	HashSet<String> set = new HashSet<>();

	for (String s: wl){
		s = s.replaceAll("\\.","").replaceAll(",","").replaceAll("!","").replaceAll("\\?","").replaceAll("'","").replaceAll(";","").toLowerCase();
		if (map.containsKey(s)) map.put(s, map.get(s) + 1);
		else map.put(s, 1);
	}

	for (String s: banned) set.add(s.toLowerCase());

	int max = 0;
	String result = "N/A";
	for (String s: map.keySet()){
		if (set.contains(s)) continue;

		int freq = map.get(s);
		if (freq > max){
			max = freq;
			result = s;
		}
	}

	return result;
    }
}
