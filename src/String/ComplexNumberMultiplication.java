package String;

public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String a, String b) {
        String[] s1 = a.split("\\+");
        String[] s2 = b.split("\\+");
        int x1 = Integer.valueOf(s1[0]);
        int x2 = Integer.valueOf(s1[1].substring(0, s1[1].length() - 1));
        int y1 = Integer.valueOf(s2[0]);
        int y2 = Integer.valueOf(s2[1].substring(0, s2[1].length() - 1));

        int res1 = x1 * y1 - x2 * y2;
        int res2 = x1 * y2 + x2 * y1;

        return String.valueOf(res1) + "+" + String.valueOf(res2) + "i";
    }
}
