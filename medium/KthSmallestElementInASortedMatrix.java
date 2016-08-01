public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((i1, i2) -> i1[0] - i2[0]);
        pq.add(new int[]{matrix[0][0], 0, 0});
        while(k > 1) {
            int[] cur = pq.poll();
            if(cur[1] + 1 < matrix.length) {
                pq.add(new int[]{matrix[cur[1] + 1][cur[2]], cur[1] + 1, cur[2]});
            }
            if(cur[1] == 0 && cur[2] + 1 < matrix[0].length) {
                pq.add(new int[]{matrix[0][cur[2] + 1], 0, cur[2] + 1});
            }
            k--;
        }
        return pq.peek()[0];
    }
}
