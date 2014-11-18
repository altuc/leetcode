public class Solution1 {
    public String addBinary(String a, String b) {
		if (a.length() > b.length()) {
			String fill = "";
			for (int i = 0; i < a.length() - b.length(); i++) {
				fill += "0";
			}
			b = fill + b;
		} else {
			String fill = "";
			for (int i = 0; i < b.length() - a.length(); i++) {
				fill += "0";
			}
			a = fill + a;
		}
		StringBuilder sb = new StringBuilder();
		for (int k = a.length() - 1; k >= 0; k--) {
			if (a.charAt(k) == '0' && b.charAt(k) == '0') {
				if (sb.length() == 0) {
					sb.insert(0, "00");
				} else {
					if (sb.charAt(0) != '1') {
						sb.deleteCharAt(0);
						sb.insert(0, "00");
					} else {
						sb.insert(0, "0");
					}
				}
			} else if ((a.charAt(k) == '0' && b.charAt(k) == '1') || (a.charAt(k) == '1' && b.charAt(k) == '0')) {
				if (sb.length() == 0) {
					sb.insert(0, "01");
				} else {
					if (sb.charAt(0) != '1') {
						sb.deleteCharAt(0);
						sb.insert(0, "01");
					} else {
						sb.deleteCharAt(0);
						sb.insert(0, "10");
					}
				}
			} else {
				if (sb.length() == 0) {
					sb.insert(0, "10");
				} else {
					if (sb.charAt(0) != '1') {
						sb.deleteCharAt(0);
						sb.insert(0, "10");
					} else {
						sb.deleteCharAt(0);
						sb.insert(0, "11");
					}
				}
			}
		}
		if (sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}
}

public class Solution2 {
    public String addBinary(String a, String b) {
		if (a.length() > b.length()) {
			String fill = "";
			for (int i = 0; i < a.length() - b.length(); i++) {
				fill += "0";
			}
			b = fill + b;
		} else {
			String fill = "";
			for (int i = 0; i < b.length() - a.length(); i++) {
				fill += "0";
			}
			a = fill + a;
		}
		StringBuilder sb = new StringBuilder();
		int carries = 0;
		for (int k = a.length() - 1; k >= 0; k--) {
			if (a.charAt(k) == '0' && b.charAt(k) == '0') {
				if (sb.length() == 0) {
					sb.insert(0, "0");
				} else {
					if (carries == 0) {
						sb.insert(0, "0");
					} else {
						sb.insert(0, "1");
						carries = 0;
					}
				}
			} else if ((a.charAt(k) == '0' && b.charAt(k) == '1') || (a.charAt(k) == '1' && b.charAt(k) == '0')) {
				if (sb.length() == 0) {
					sb.insert(0, "1");
				} else {
					if (carries == 0) {
						sb.insert(0, "1");
					} else {
						sb.insert(0, "0");
					}
				}
			} else {
				if (sb.length() == 0) {
					sb.insert(0, "0");
					carries = 1;
				} else {
					if (carries == 0) {
						sb.insert(0, "0");
						carries = 1;
					} else {
						sb.insert(0, "1");
					}
				}
			}
		}
		if (carries == 1) {
			sb.insert(0, "1");
		}
		return sb.toString();
	}
}