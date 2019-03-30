package String;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    /**
     * @param strs: a list of strings
     * @return encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();
    }

    /**
     * @param str: A string
     * @return decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int from = 0, idx = 0;
        while (idx < str.length()) {
            while (str.charAt(idx) != '/') {
                idx++;
            }
            int len = Integer.parseInt(str.substring(from, idx));
            res.add(str.substring(idx + 1, idx + 1 + len));
            from = idx + len + 1;
            idx = from + 1;
        }
        return res;
    }
}
