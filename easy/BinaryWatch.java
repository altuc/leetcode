public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        for(int h = 0; h < 12; h++) {
            for(int m = 0; m < 60; m++) {
                int count = 0;
                int time = h * 64 + m;
                for(int i = 0; i < 10; i++) {
                    count += (time >> i) & 1;
                }
                if(count == num) {
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return res;
    }
}
