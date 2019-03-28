class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (String log : logs) {
            String[] strs = log.split(":");
            int id = Integer.valueOf(strs[0]), time = Integer.valueOf(strs[2]);
            if (strs[1].equals("start"))
                stack.push(new int[]{id, time});
            else {
                int v = time - stack.pop()[1] + 1;
                res[id] += v;
                if (!stack.isEmpty()) res[stack.peek()[0]] -= v;
            }
        }
        return res;
    }
}
