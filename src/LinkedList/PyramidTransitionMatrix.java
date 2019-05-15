package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidTransitionMatrix {

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s.substring(2, 3));
        }

        return help(bottom, map);
    }

    private boolean help(String bottom, Map<String, List<String>> map) {
        if (bottom.length() == 1) {
            return true;
        }

        for (int i = 0, len = bottom.length(); i < len - 1; i++) {
            if (!map.containsKey(bottom.substring(i, i + 2))) {
                return false;
            }
        }

        List<String> upLevel = new ArrayList<>();
        getUpLevel(bottom, 0, new StringBuilder(), map, upLevel);

        for (String up : upLevel) {
            if (help(up, map)) {
                return true;
            }
        }
        return false;
    }

    private void getUpLevel(String bottom, int idx, StringBuilder sb, Map<String, List<String>> map, List<String> list) {
        if (idx == bottom.length()) {
            list.add(sb.toString());
            return;
        }

        for (String s : map.get(bottom.substring(idx, idx + 2))) {
            sb.append(s);
            getUpLevel(bottom, idx + 1, sb, map, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
