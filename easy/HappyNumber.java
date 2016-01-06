public class Solution {
    public boolean isHappy(int n) {
        if(n <= 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)) {
            set.add(n);
            int next = 0;
            while(n != 0) {
                next += (n % 10) * (n % 10);
                n /= 10;
            }
            n = next;
        }
        return n == 1;
    }
}
