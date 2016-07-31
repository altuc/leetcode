public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) {
            return res;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((i1, i2) -> i1[0] + i1[1] - i2[0] - i2[1]);
        for(int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new int[]{nums1[i], nums2[0], 0});
        }
        while(k > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            res.add(new int[]{pair[0], pair[1]});
            if(pair[2] < nums2.length - 1) {
                pq.add(new int[]{pair[0], nums2[pair[2] + 1], pair[2] + 1});
            }
            k--;
        }
        return res;
    }
}
