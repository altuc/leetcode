public class Solution1 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        String s = "";
        if(nums == null || nums.length == 0) {
            if(lower == upper) {
                s = Integer.toString(lower);
            } else {
                s = Integer.toString(lower) + "->" + Integer.toString(upper);
            }
            res.add(s);
            return res;
        }
        if(nums[0] > lower) {
            s = Integer.toString(lower);
        }
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                if(nums[i] > lower && nums[i] == lower + 1) {
                    res.add(s);
                } 
                if(nums[i] > lower && nums[i] != lower + 1) {
                    s = s + "->" + Integer.toString(nums[i] - 1);
                    res.add(s);
                }
                continue;
            }
            if(nums[i] != nums[i - 1] + 1) {
                s = Integer.toString(nums[i - 1] + 1);
                if(nums[i] == nums[i - 1] + 2) {
                    res.add(s);
                } else {
                    s = s + "->" + Integer.toString(nums[i] - 1);
                    res.add(s);
                }
            }
        }
        if(nums[nums.length - 1] < upper) {
            s = Integer.toString(nums[nums.length - 1] + 1);
            if(upper == nums[nums.length - 1] + 1) {
                res.add(s);
            } else {
                s = s + "->" + Integer.toString(upper);
                res.add(s);
            }
        }
        return res;
    }
}

public class Solution2 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        for(int i = 0; i <= nums.length; i++) {
            int start = i == 0 ? lower : nums[i - 1] + 1;
            int end = i == nums.length ? upper : nums[i] - 1;
            findMissingRangesHelper(res, start, end);
        }
        return res;
    }
    
    public void findMissingRangesHelper(List<String> res, int start, int end) {
        String s = "";
        if(start > end) {
            return;
        } else if(start == end) {
            s = Integer.toString(start);
            res.add(s);
        } else {
            s = Integer.toString(start) + "->" + Integer.toString(end);
            res.add(s);
        }
    }
}
