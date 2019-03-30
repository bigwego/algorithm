package String;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                int cnt = len / i;
                int j = 0;
                for (; j < i; j++) {
                    int k = j + i;
                    for (; k < len; k += i) {
                        if (s.charAt(j) != s.charAt(k)) {
                            break;
                        }
                    }
                    if (k < len) {
                        break;
                    }
                }
                if (j == i) {
                    return true;
                }
            }
        }
        return false;
    }
}
