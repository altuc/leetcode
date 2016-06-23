public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        String s = Integer.toString(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1] + 1) {
                if(s.indexOf("->") == -1) {
                    s += "->";
                }
            } else {
                if(s.indexOf("->") != -1) {
                    s += Integer.toString(nums[i - 1]);
                }
                res.add(s);
                s = Integer.toString(nums[i]);
            }
        }
        if(s.indexOf("->") != -1) {
            s += nums[nums.length - 1];
        } 
        res.add(s);
        return res;
    }
}
