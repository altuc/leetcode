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

public class Solution3 {
    public String addBinary(String a, String b) {
        if(a == null || a.isEmpty()) {
            return b;
        }
        if(b == null || b.isEmpty()) {
            return a;
        }
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(pa >= 0 || pb >= 0) {
            int sum = carry;
            if(pa >= 0) {
                sum += a.charAt(pa) - '0';
                pa--;
            }
            if(pb >= 0) {
                sum += b.charAt(pb) - '0';
                pb--;
            }
            sb.insert(0, sum % 2);
            carry = sum >= 2 ? 1 : 0;
        }
        if(carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
