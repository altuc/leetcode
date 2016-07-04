public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return nums;
        }
        LinkedList<Integer> index = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++) {
            if(!index.isEmpty() && index.peek() < i - k + 1) {
                index.poll();
            }
            while(!index.isEmpty() && nums[i] >= nums[index.peekLast()]) {
                index.pollLast();
            }
            index.add(i);
            if(i - k + 1 >= 0) {
                res[i - k + 1] = nums[index.peek()];
            }
        }
        return res;
    }
}
