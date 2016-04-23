public class Solution {
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for(int num : nums) {
            temp = temp ^ num;
        }
        int lowDiff = temp & -temp;
        int[] res = new int[2];
        for(int num : nums) {
            if((num & lowDiff) == 0) {
                res[0] = res[0] ^ num;
            } else {
                res[1] = res[1] ^ num;
            }
        }
        return res;
    }
}
