// Reservoir sampling
public class Solution1 {
    
    private Random random = null;
    private int[] nums = null;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    public int pick(int target) {
        int index = -1;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                if(random.nextInt(++count) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }
}

public class Solution2 {
    
    private HashMap<Integer, List<Integer>> map = null;

    public Solution(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<Integer>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        Random r = new Random();
        int index = r.nextInt(map.get(target).size());
        return map.get(target).get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
