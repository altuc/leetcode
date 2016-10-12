public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> sta = new Stack<Integer>();
        int min = Integer.MIN_VALUE;
        for(int n : preorder) {
            if(n < min) {
                return false;
            }
            while(!sta.empty() && n > sta.peek()) {
                min = sta.pop();
            }
            sta.push(n);
        }
        return true;
    }
}
