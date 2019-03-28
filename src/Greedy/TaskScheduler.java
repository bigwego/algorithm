class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] hash = new int[26];
        for (char c : tasks) hash[c - 'A']++;
        Arrays.sort(hash);
        int i = 25;
        while (i > -1 && hash[i] == hash[25]) i--;
        return Math.max(tasks.length, (hash[25] - 1) * (n + 1) + 25 - i);
    }
}
