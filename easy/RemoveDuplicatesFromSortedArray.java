public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length == 0 || A.length == 1) {
            return A.length;
        }
        int k = 0;
        for(int i = 0; i < A.length - 1; i++) {
            if(A[i] != A[i+1]) {
                A[k] = A[i];
                A[k+1] = A[i+1];
                k++;
            }
        }
        return k + 1;
    }
}
