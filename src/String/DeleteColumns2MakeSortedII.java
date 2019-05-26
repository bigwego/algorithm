package String;

public class DeleteColumns2MakeSortedII {

    public static void main(String[] args) {
        System.out.println(f());
    }

    private static String f() {
        try {
            return "try";
        } finally {
            return "finally";
        }
    }

    public int minDeletionSize(String[] A) {
        int i = 0;
        boolean valid = true;
        for (int len1 = A[0].length(); i < len1 && valid; i++) {
            int j = 0;
            for (int len2 = A.length; j < len2 - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    valid = false;
                    break;
                }
            }
            if (j == A.length - 1) {
                break;
            }
        }
        return i;
    }
}
