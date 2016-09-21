public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        List<int[]> heights = new ArrayList<int[]>();
        for(int[] building : buildings) {
            heights.add(new int[]{ building[0], building[2] });
            heights.add(new int[]{ building[1], -building[2] });
        }
        Collections.sort(heights, (h1, h2) -> {
            if(h1[0] != h2[0]) {
                return h1[0] - h2[0];
            } else {
                return h2[1] - h1[1];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((i1, i2) -> i2 - i1);
        pq.add(0);
        int pre = 0;
        for(int[] height : heights) {
            if(height[1] > 0) {
                pq.add(height[1]);
            } else {
                pq.remove(-height[1]);
            }
            int cur = pq.peek();
            if(pre != cur) {
                res.add(new int[]{ height[0], cur });
                pre = cur;
            }
        }
        return res;
    }
}
