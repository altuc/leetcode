public class Solution1 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

public class Solution2 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num: nums) {
            if (!map.containsKey(num)){
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > nums.length / 2) {
                res = num;
                break;
            }
        }
        return res;
    }
}

public class Solution3 {
    public int majorityElement(int[] nums) {
        int majority = 0;
        int counter = 0;
        for(int i = 0; i < nums.length; i++) {
            if(counter == 0) {
                counter++;
                majority = nums[i];
            } else {
                if(nums[i] == majority) {
                    counter++;
                } else {
                    counter--;
                }
            }
        }
        return majority;
    }
}
