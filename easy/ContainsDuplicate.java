public class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) {
            if(!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}

public class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
