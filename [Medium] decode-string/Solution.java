class Solution {
	public String decodeString(String os) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i< os.length(); ++i){
			if ((os.charAt(i) >= 'A' && os.charAt(i) <= 'Z') || (os.charAt(i) >= 'a' && os.charAt(i) <= 'z')) sb.append(os.charAt(i));
			else {
				int num = 0;
				for (;os.charAt(i) != '['; ++i) num = num * 10 + (os.charAt(i) - '0');

				StringBuilder s = new StringBuilder();
				int count = 1;
				++i;	// Discard character: [
				for (; count != 0; ++i){
					if (os.charAt(i) == '[') ++count;
					else if (os.charAt(i) == ']') --count;
					s.append(os.charAt(i));
				}
				s.setLength(s.length() - 1);
				String repeat = decodeString(s.toString());
				for (int j = 0; j < num; ++j) sb.append(repeat);
				--i;	// Get back the last character
			} 
		}
		return sb.toString();
	}
}
