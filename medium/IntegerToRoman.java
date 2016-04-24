public class Solution {
    public String intToRoman(int num) {
        if(num <= 0) {
            return "";
        }
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int digit = 0;
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            int times = num / nums[digit];
            num -= nums[digit] * times;
            while(times > 0) {
                sb.append(symbols[digit]);
                times--;
            }
            digit++;
        }
        return sb.toString();
    }
}
