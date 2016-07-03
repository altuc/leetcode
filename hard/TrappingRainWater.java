public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 3) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int res = 0;
        while(left < right) {
            if(leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                res += rightMax - height[right];
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return res;
    }
}
