public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int cur = a >= 0 ? right : left;
        while(left <= right) {
            if(a >= 0) {
                res[cur--] = calculate(a, b, c, nums[left]) >= calculate(a, b, c, nums[right]) ? calculate(a, b, c, nums[left++]) : calculate(a, b, c, nums[right--]);
            } else {
                res[cur++] = calculate(a, b, c, nums[left]) <= calculate(a, b, c, nums[right]) ? calculate(a, b, c, nums[left++]) : calculate(a, b, c, nums[right--]);
            }
        }
        return res;
    }
    
    public int calculate(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
}
