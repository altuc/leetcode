public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int posA = a.length() - 1;
        int posB = b.length() - 1;
        int carry = 0;
        while(posA >= 0 || posB >= 0) {
            int temp = carry;
            if(posA >= 0) {
                temp += a.charAt(posA) - '0';
                posA--;
            }
            if(posB >= 0) {
                temp += b.charAt(posB) - '0';
                posB--;
            }
            sb.insert(0, temp % 2);
            carry = temp / 2;
        }
        if(carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
