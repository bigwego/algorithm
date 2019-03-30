package HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 10) {
            return res;
        }
        Set<Integer> once = new HashSet<>();
        Set<Integer> moreThanOnce = new HashSet<>();
        int[] hash = new int[26];
        hash['C' - 'A'] = 1;
        hash['G' - 'A'] = 2;
        hash['T' - 'A'] = 3;
        for (int i = 0, len = s.length(); i < len - 9; i++) {
            int mask = 0;
            for (int j = i; j < i + 10; j++) {
                mask <<= 2;
                mask |= hash[s.charAt(j) - 'A'];
            }
            if (!once.add(mask) && moreThanOnce.add(mask)) {
                res.add(s.substring(i, i + 10));
            }
        }
        return res;
    }
}
