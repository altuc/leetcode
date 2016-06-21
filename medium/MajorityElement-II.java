public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        int candidate1 = 0, candidate2 = 0, counter1 = 0, counter2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == candidate1) {
                counter1++;
            } else if(nums[i] == candidate2) {
                counter2++;
            } else if(counter1 == 0) {
                counter1++;
                candidate1 = nums[i];
            } else if(counter2 == 0) {
                counter2++;
                candidate2 = nums[i];
            } else {
                counter1--;
                counter2--;
            }
        }
        counter1 = 0;
        counter2 = 0;
        for(int i : nums) {
            if(i == candidate1) {
                counter1++;
            } else {
                if(i == candidate2) {
                    counter2++;
                }
            }
        }
        if(counter1 > nums.length / 3) {
            res.add(candidate1);
        }
        if(counter2 > nums.length / 3) {
            res.add(candidate2);
        }
        return res;
    }
}
