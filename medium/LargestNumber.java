public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return "";
        }
        int len = nums.length;
        String[] strs = new String[len];
        for(int i = 0; i < len; i++) {
            strs[i] = nums[i] + "";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        });
        if(strs[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
