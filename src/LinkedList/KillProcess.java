package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class KillProcess {

    /**
     * @param pid:  the process id
     * @param ppid: the parent process id
     * @param kill: a PID you want to kill
     * @return a list of PIDs of processes that will be killed in the end
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (!map.containsKey(ppid.get(i))) {
                map.put(ppid.get(i), new ArrayList<>());
            }
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> res = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList();
        queue.add(kill);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int p = queue.poll();
                res.add(p);
                if (map.containsKey(p)) {
                    queue.addAll(map.get(p));
                }
            }
        }
        return res;
    }
}
