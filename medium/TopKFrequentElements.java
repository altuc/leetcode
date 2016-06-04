public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(int key : map.keySet()) {
            if(bucket[map.get(key)] == null) {
                bucket[map.get(key)] = new ArrayList<Integer>();
            }
            bucket[map.get(key)].add(key);
        }
        for(int i = bucket.length - 1; i >= 0; i--) {
            if(bucket[i] == null) {
                continue;
            }
            for(int j = 0; j < bucket[i].size(); j++) {
                res.add(bucket[i].get(j));
                if(res.size() == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
