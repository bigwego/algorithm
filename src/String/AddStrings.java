package String;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for (int i1 = num1.length() - 1, i2 = num2.length() - 1; i1 > -1 || i2 > -1; ) {
            int x = i1 == -1 ? 0 : num1.charAt(i1--) - '0';
            int y = i2 == -1 ? 0 : num2.charAt(i2--) - '0';
            sb.append((x + y + c) % 10);
            c = (x + y + c) / 10;
        }
        if (c != 0) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
