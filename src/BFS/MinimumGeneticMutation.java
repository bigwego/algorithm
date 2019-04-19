package BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {
        char[] genes = new char[]{ 'A', 'C', 'G', 'T' };
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>();
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                for (int j = 0; j < curr.length(); j++) {
                    char[] chs = curr.toCharArray();
                    for (char gene : genes) {
                        chs[j] = gene;

                        String temp = new String(chs);
                        if (temp.equals(end) && bankSet.contains(temp)) {
                            return step;
                        }
                        if (!visited.contains(temp) && bankSet.contains(temp)) {
                            visited.add(temp);
                            queue.add(temp);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public int minMutation2(String start, String end, String[] bank) {
        Set<String> genes = new HashSet<>(Arrays.asList(bank));
        char[] chs = new char[]{ 'A', 'C', 'G', 'T' };
        LinkedList<String> queue = new LinkedList<>();
        queue.add(start);
        int res = 1;
        while (!queue.isEmpty()) {
            for (int i = 0, sz = queue.size(); i < sz; i++) {
                String curr = queue.poll();
                if (curr.equals(end)) {
                    return res;
                }
                for (int j = 0, len = curr.length(); j < len; j++) {
                    char[] tmp = curr.toCharArray();
                    for (char c : chs) {
                        if (c != tmp[j]) {
                            tmp[j] = c;
                            String tmpStr = String.valueOf(tmp);
                            if (genes.contains(tmpStr)) {
                                queue.add(tmpStr);
                                genes.remove(tmpStr);
                            }
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
