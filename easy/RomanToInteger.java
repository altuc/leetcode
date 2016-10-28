public class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int start = s.length() - 1;
        for(int i = start; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I':
                    res += res >= 5 ? -1 : 1;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += res >= 50 ? -10 : 10;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += res >= 500 ? -100 : 100;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
                default:
                    break;
            }
        }
        return res;
    }
}
