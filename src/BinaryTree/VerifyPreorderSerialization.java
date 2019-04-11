package BinaryTree;

public class VerifyPreorderSerialization {

    public boolean isValidSerialization(String preorder) {
        if (preorder.charAt(0) == '#') {
            return preorder.length() == 1;
        }
        int degree = 1;
        for (int i = 0, len = preorder.length(); i < len; i += 2) {
            if (--degree < 0) {
                return false;
            }
            if (preorder.charAt(i) != '#') {
                while (i + 1 < len && preorder.charAt(i + 1) != ',') {
                    i++;
                }
                degree += 2;
            }
        }
        return degree == 0;
    }
}
