public class Solution1 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int length1 = C - A;
        int width1 = D - B;
        int length2 = G - E;
        int width2 = H - F;
        int totalArea = length1 * width1 + length2 * width2;
        int length3 = 0;
        int width3 = 0;
        if(A <= E && E < C && C <= G) {
            length3 = C - E;
        }
        if(E <= A && A < G && G <= C) {
            length3 = G - A;
        }
        if(E <= A && A < C && C <= G) {
            length3 = C - A;
        }
        if(A <= E && E < G && G <= C) {
            length3 = G - E;
        }
        if(B <= F && F < D && D <= H) {
            width3 = D - F;
        }
        if(F <= B && B < H && H <= D) {
            width3 = H - B;
        }
        if(F <= B && B < D && D <= H) {
            width3 = D - B;
        }
        if(B <= F && F < H && H <= D) {
            width3 = H - F;
        }
        totalArea -= length3 * width3;
        return totalArea;
    }
}

public class Solution2 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A >= G || E >= C || B >= H || F >= D) {
            return (C - A) * (D - B) + (G - E) * (H - F);
        }
        int x1 = Math.max(A, E);
        int y1 = Math.max(B, F);
        int x2 = Math.min(C, G);
        int y2 = Math.min(D, H);
        return (C - A) * (D - B) + (G - E) * (H - F) - (x2 - x1) * (y2 -y1);
    }
}
