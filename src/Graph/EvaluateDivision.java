class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] eq = equations[i];
            if (!map.containsKey(eq[0])) {
                map.put(eq[0], new HashMap<>());
            }
            if (!map.containsKey(eq[1])) {
                map.put(eq[1], new HashMap<>());
            }
            map.get(eq[0]).put(eq[1], values[i]);
            map.get(eq[1]).put(eq[0], 1 / values[i]);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = dfs(map, queries[i][0], queries[i][1], new HashSet<String>(), 1);
        }
        return res;
    }

    private double dfs(Map<String, Map<String, Double>> map, String s1, String s2, HashSet<String> set, double r) {
        if (!map.containsKey(s1) || !map.containsKey(s2) || set.contains(s1)) {
            return -1;
        }
        if (s1.equals(s2)) {
            return r;
        }
        set.add(s1);
        Map<String, Double> nextMap = map.get(s1);
        for (String next : nextMap.keySet()) {
            double res = dfs(map, next, s2, set, r * nextMap.get(next));
            if (res != -1) {
                return res;
            }
        }
        return -1;
    }
}
