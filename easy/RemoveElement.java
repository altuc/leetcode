public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A.length == 0) {
            return A.length;
        }
        int k = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] != elem) {
                A[k] = A[i];
                k++;
            }
        }
        return k;
    }
}