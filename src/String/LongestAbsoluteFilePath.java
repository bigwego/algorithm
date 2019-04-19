package String;

public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        String[] strs = input.split("\n");
        int[] stack = new int[strs.length + 1];
        int maxLen = 0;
        for (String s : strs) {
            int lev = s.lastIndexOf("\t") + 1;
            int currLen = stack[lev + 1] = stack[lev] + s.length() - lev + 1;
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, currLen - 1);
            }
        }
        return maxLen;
    }
}
