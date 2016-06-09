public class Solution1 {
    public String convertToTitle(int n) {
        String res = "";
        while(n != 0) {
            char ch = (char) ((n - 1) % 26 + 65);
            n = (n - 1) / 26;
            res = ch + res;
        }
        return res;
    }
}

public class Solution2 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            char c = (char)('A' + (n - 1) % 26);
            sb.insert(0, c);
            n = (n - 1) / 26;
        }
        return sb.toString();
    }
}
