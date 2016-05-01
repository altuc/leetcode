public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int factorial = 1;
        for(int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i = n; i > 0; i--) {
            factorial /= i;
            sb.append(list.remove(k / factorial));
            k %= factorial;
        }
        return sb.toString();
    }
}
