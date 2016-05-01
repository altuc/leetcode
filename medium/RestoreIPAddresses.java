public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        restoreIpAddressesHelper(s, res, "", 0, 0);
        return res;
    }
    
    public void restoreIpAddressesHelper(String s, List<String> res, String temp, int count, int start) {
        if(count == 4) {
            if(start == s.length()) {
                res.add(temp);
                return;
            } else {
                return;
            }
        }
        for(int i = 1; i < 4; i++) {
            if(start + i > s.length()) {
                return;
            }
            String str = s.substring(start, start + i);
            if ((str.startsWith("0") && str.length() > 1) || (i == 3 && Integer.parseInt(str) > 255)) {
                return;
            }
            restoreIpAddressesHelper(s, res, temp + str + (count < 3 ? "." : ""), count + 1, start + i);
        }
    }
}
