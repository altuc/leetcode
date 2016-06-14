public class Solution1 {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int h = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            if(citations[i] > h) {
                h++;
            }
        }
        return h;
    }
}

public class Solution2 {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            if(citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        return 0;
    }
}

