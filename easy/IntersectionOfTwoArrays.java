public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> interSet = new HashSet<Integer>();
        for(int num : nums1) {
            set.add(num);
        }
        for(int num : nums2) {
            if(set.contains(num)) {
                interSet.add(num);
            }
        }
        int[] res = new int[interSet.size()];
        int index = 0;
        for(int num : interSet) {
            res[index] = num;
            index++;
        }
        return res;
    }
}
