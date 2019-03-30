package HashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
public class EmployeeImportance {

    private Map<Integer, Pair> map;

    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, new Pair(emp.importance, emp.subordinates));
        }
        return help(id, map);
    }

    private int help(int id, Map<Integer, Pair> map) {
        Pair curr = map.get(id);
        int res = curr.importance;
        if (curr.nexts.size() != 0) {
            for (int next : curr.nexts) {
                res += help(next, map);
            }
        }
        return res;
    }

    private class Pair {
        int importance;

        List<Integer> nexts;

        Pair(int importance, List<Integer> nexts) {
            this.importance = importance;
            this.nexts = nexts;
        }
    }

    private class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        int id;

        // the importance value of this employee
        int importance;

        // the id of direct subordinates
        List<Integer> subordinates;
    }
}
