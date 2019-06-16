package DynamicProgramming;

public class DecodeWays {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));
            if (0 < oneDigit && oneDigit < 10) {
                dp[i] += dp[i - 1];
            }
            if (9 < twoDigits && twoDigits < 27) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[dp.length - 1];
    }

    public int numDecodings2(String s) {
        if (s == null || s.length() == 0) return 0;

        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= len; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (0 < one && one < 10)
                dp[i] += dp[i - 1];
            if (9 < two && two < 27)
                dp[i] += dp[i - 2];
        }

        return dp[len];
    }
}
