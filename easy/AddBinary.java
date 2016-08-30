public class Solution {
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
