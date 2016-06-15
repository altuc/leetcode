public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        int start = 0;
        int end = len - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(citations[mid] > len - mid) {
               end = mid - 1;
            } else if(citations[mid] < len - mid) {
                start = mid + 1;
            } else {
                return len - mid;
            }
        }
        return len - start;
    }
}
