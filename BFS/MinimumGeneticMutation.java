class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        char[] genes = new char[]{'A', 'C', 'G', 'T'};
        Set<String> bankSet = new HashSet<String>(Arrays.asList(bank));
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
}
