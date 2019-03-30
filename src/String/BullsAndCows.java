package String;

public class BullsAndCows {

    public String getHint(String secret, String guess) {
        int[] hash = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (hash[secret.charAt(i) - '0']++ < 0) {
                    cows++;
                }
                if (hash[guess.charAt(i) - '0']-- > 0) {
                    cows++;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }
}
