package String;

public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        for (char c : word.toCharArray()) {
            if (c <= 'Z') {
                cnt++;
            }
        }
        return (cnt == 0) || (word.charAt(0) <= 'Z' && (cnt == 1 || cnt == word.length()));
    }
}
