package String;

public class ShortestCompletingWord {

    private static final int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
            61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };

    public String shortestCompletingWord(String licensePlate, String[] words) {
        long product = getProduct(licensePlate.toLowerCase());
        String res = "aaaaaaaaaaaaaaaa";
        for (String word : words) {
            if (word.length() < res.length() && getProduct(word) % product == 0) {
                res = word;
            }
        }
        return res;
    }

    private long getProduct(String licensePlate) {
        long res = 1L;
        for (char c : licensePlate.toCharArray()) {
            int idx = c - 'a';
            if (idx > -1 && idx < 26) {
                res *= primes[idx];
            }
        }
        return res;
    }
}
