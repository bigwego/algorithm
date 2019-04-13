package Design;

import java.util.List;

public class NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        int res = 0;
        for (NestedInteger ni : nestedList) {
            res += help(ni, 1);
        }
        return res;
    }

    private int help(NestedInteger ni, int depth) {
        int res = 0;
        if (ni.isInteger()) {
            res += ni.getInteger() * depth;
        } else {
            for (NestedInteger next : ni.getList()) {
                res += help(next, depth + 1);
            }
        }
        return res;
    }
}