public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int pos1 = num1.length() - 1;
        int pos2 = num2.length() - 1;
        int carry = 0;
        while(pos1 >= 0 || pos2 >= 0) {
            int sum = carry;
            if(pos1 >= 0) {
                sum += num1.charAt(pos1) - '0';
                pos1--;
            }
            if(pos2 >= 0) {
                sum += num2.charAt(pos2) - '0';
                pos2--;
            }
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        if(carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
