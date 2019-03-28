public class OutputContestMatches {
    /**
     * @param n: a integer, denote the number of teams
     * @return: a string
     */
    public String findContestMatch(int n) {
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            queue.add(String.valueOf(i));
        return help(queue, new LinkedList<>());
    }

    private String help(LinkedList<String> curr, LinkedList<String> tmp) {
        if (curr.size() == 1) return curr.poll();
        for (int i = 0, len = curr.size() / 2; i < len; i++)
            tmp.add("(" + curr.pollFirst() + "," + curr.pollLast() + ")");
        return help(tmp, curr);
    }
}
