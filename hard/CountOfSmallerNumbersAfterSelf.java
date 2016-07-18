public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> sortedList = new ArrayList<Integer>();
        for(int i = nums.length - 1; i >= 0; i--) {
            int count = countSmallerHelper(sortedList, nums[i]);
            res.add(0, count);
            sortedList.add(count, nums[i]);
        }
        return res;
    }
    
    public int countSmallerHelper(List<Integer> sortedList, int num) {
        if(sortedList.isEmpty()) {
            return 0;
        }
        if(num <= sortedList.get(0)) {
            return 0;
        }
        if(num > sortedList.get(sortedList.size() - 1)) {
            return sortedList.size();
        }
        int start = 0;
        int end = sortedList.size() - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(sortedList.get(mid) >= num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
