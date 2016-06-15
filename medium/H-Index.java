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

public class Solution3 {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        int[] index = new int[len + 1];
        for(int n : citations) {
            if(n >= len) {
                index[len]++;
            } else {
                index[n]++;
            }
        }
        int total = 0;
        for(int i = len; i >= 0; i--) {
            total += index[i];
            if(total >= i) {
                return i;
            }
        }
        return 0;
    }
}

