public class Solution {
	public String reverse(String str) {
		StringBuffer sb = new StringBuffer();
		for(int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
}