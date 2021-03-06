package String;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 1, len = strs.length; i < len; i++) {
            while (!strs[i].startsWith(pre)) {
                pre = pre.substring(0, pre.length() - 1);
            }
            if (pre.equals("")) {
                break;
            }
        }
        return pre;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String pre = strs[0];
        for (int i = 1, len = strs.length; i < len; i++) {
            while (!strs[i].startsWith(pre)) {
                pre = pre.substring(0, pre.length() - 1);
            }
            if (pre.equals("")) break;
        }

        return pre;
    }

    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String res = strs[0];

        for (int i = 1, len = strs.length; i < len; i++) {
            while (!strs[i].startsWith(res))
                res = res.substring(0, res.length() - 1);
            if (res.equals("")) break;
        }

        return res;
    }
}
