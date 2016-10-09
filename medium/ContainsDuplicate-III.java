public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length <= 1 || k < 1 || t < 0) {
            return false;
        }
        Map<Long, Long> map = new HashMap<Long, Long>();
        long size = (long)t + 1;
        for(int i = 0; i < nums.length; i++) {
            long index = getKey(nums[i], size);
            if(map.containsKey(index)) {
                return true;
            }
            if(map.containsKey(index - 1) && Math.abs(nums[i] - map.get(index - 1)) <= t) {
                return true;
            }
            if(map.containsKey(index + 1) && Math.abs(nums[i] - map.get(index + 1)) <= t) {
                return true;
            }
            if(i >= k) {
                map.remove(getKey(nums[i - k], size));
            }
            map.put(index, (long)nums[i]);
        }
        return false;
    }
    
    private long getKey(long num, long size) {
        return num < 0 ? (num + 1) / size - 1 : num / size;
    }
}
