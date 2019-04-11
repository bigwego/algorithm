package Others;

public class RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (A - C) * (B - D);
        int area2 = (E - G) * (F - H);
        int overlap = 0;
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int up = Math.min(D, H);
        int down = Math.max(B, F);
        if (right > left && up > down) {
            overlap = (right - left) * (up - down);
        }
        return area1 + area2 - overlap;
    }
}
