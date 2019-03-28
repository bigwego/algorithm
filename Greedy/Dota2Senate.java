class Dota2Senate {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        LinkedList<Integer> rQueue = new LinkedList<>();
        LinkedList<Integer> dQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') rQueue.add(i);
            else dQueue.add(i);
        }
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            if (rQueue.peek() < dQueue.peek()) {
                rQueue.add(rQueue.poll() + n);
                dQueue.poll();
            } else {
                dQueue.add(dQueue.poll() + n);
                rQueue.poll();
            }
        }
        return rQueue.size() != 0 ? "Radiant" : "Dire";
    }
}
