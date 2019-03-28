class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] hash = new int[10];
		int cows = 0, bulls = 0;
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
