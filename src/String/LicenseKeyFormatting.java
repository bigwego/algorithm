package String;

public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i > -1; i--) {
            if (S.charAt(i) != '-') {
                sb.append(sb.length() % (K + 1) == K ? "-" : "").append(S.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }

    public String licenseKeyFormatting2(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (int i = S.length() - 1; i > -1; i--) {
            if (S.charAt(i) == '-') continue;
            sb.append(Character.toUpperCase(S.charAt(i)));
            if (++cnt % K == 0) sb.append("-");
        }

        return sb.reverse().toString();
    }
}
