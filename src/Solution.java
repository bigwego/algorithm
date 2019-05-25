public class Solution {

    public static void main() {
        System.out.println(a());
    }

    private static String a() {
        String str = "return";
        try {
            return str;
        } finally {
            String a = "a";
            return a;
        }
    }
}