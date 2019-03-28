class RobotReturn2Origin {
    public boolean judgeCircle(String moves) {
        int[] hash = new int[2];
        for (char c : moves.toCharArray()) {
            if (c == 'U') hash[0]++;
            else if (c == 'D') hash[0]--;
            else if (c == 'L') hash[1]++;
            else if (c == 'R') hash[1]--;
        }
        return hash[0] == 0 && hash[1] == 0;
    }
}
