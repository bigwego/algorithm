package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SequenceReconstruction {

    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        int max = 0;
        for (int[] seq : seqs) {
            for (int num : seq) {
                max = Math.max(max, num);
            }
        }
        if (org.length != max) {
            return false;
        }
        int[] indegree = new int[max];
        Set<Integer>[] graph = new HashSet[max];
        for (int i = 0; i < max; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] seq : seqs) {
            for (int i = 1, len = seq.length; i < len; i++) {
                if (!graph[seq[i - 1] - 1].contains(seq[i])) {
                    graph[seq[i - 1] - 1].add(seq[i]);
                    indegree[seq[i] - 1]++;
                }
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int idx = 0;
        for (int i = 0; i < max; i++) {
            if (indegree[i] == 0) {
                queue.add(i + 1);
            }
        }
        while (!queue.isEmpty()) {
            int sz = queue.size();
            if (sz > 1) {
                return false;
            }
            int curr = queue.poll();
            if (org[idx++] != curr) {
                return false;
            }
            for (int next : graph[curr - 1]) {
                if (--indegree[next - 1] == 0) {
                    queue.add(next);
                }
            }
        }
        return true;
    }
}
