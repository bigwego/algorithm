package String;

public class FirstUniqueCharacterInString {

    public char firstUniqChar(String str) {
        int[] cnts = new int[256];

        for (char c : str.toCharArray()) {
            cnts[c]++;
        }

        for (int i = 0, len = str.length(); i < len; i++) {
            if (cnts[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        return ' ';
    }
}
