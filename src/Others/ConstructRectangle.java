package Others;

public class ConstructRectangle {

    public int[] constructRectangle(int area) {
        int len = (int) Math.sqrt(area);
        while (area % len != 0) {
            len--;
        }
        return new int[]{ area / len, len };
    }
}
