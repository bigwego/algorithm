import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public String[] findOcurrences(String text, String first, String second) {
        String[] strs = text.split(" ");
        List<String> list = new ArrayList<>();

        for (int i = 0, len = strs.length; i < len - 2; i++) {
            if (strs[i].equals(first) && strs[i + 1].equals(second)) {
                list.add(strs[i + 2]);
            }
        }

        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}