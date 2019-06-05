package String;

public class UniqueCharacters {

    public boolean isUnique(String str) {
        int[] cnts = new int[256];

        for (char c : str.toCharArray()) {
            cnts[c]++;
        }

        for (int cnt : cnts) {
            if (cnt > 1) return false;
        }

        return true;
    }
}
