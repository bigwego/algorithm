package String;

import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString {

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = indexes.length; i < len; i++) {
            if (S.startsWith(sources[i], indexes[i])) {
                map.put(indexes[i], i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = S.length(); i < len; ) {
            if (map.containsKey(i)) {
                sb.append(targets[map.get(i)]);
                i += sources[map.get(i)].length();
            } else {
                sb.append(S.charAt(i++));
            }
        }

        return sb.toString();
    }
}
