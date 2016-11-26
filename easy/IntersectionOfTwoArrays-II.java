public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> interList = new ArrayList<Integer>();
        for(int num : nums1) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        for(int num : nums2) {
            if(map.containsKey(num) && map.get(num) > 0) {
                interList.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] res = new int[interList.size()];
        int index = 0;
        for(int num : interList) {
            res[index] = num;
            index++;
        }
        return res;
    }
}
