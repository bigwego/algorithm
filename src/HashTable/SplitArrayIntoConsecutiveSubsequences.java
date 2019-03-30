package HashTable;

import java.util.HashMap;

public class SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freqs = new HashMap<>();
        HashMap<Integer, Integer> needs = new HashMap<>();
        for (int num : nums) {
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (freqs.get(num) == 0) {
                continue;
            }
            if (needs.getOrDefault(num, 0) > 0) {
                needs.put(num, needs.get(num) - 1);
                needs.put(num + 1, needs.getOrDefault(num + 1, 0) + 1);
            } else if (freqs.getOrDefault(num + 1, 0) > 0
                    && freqs.getOrDefault(num + 2, 0) > 0) {
                freqs.put(num + 1, freqs.get(num + 1) - 1);
                freqs.put(num + 2, freqs.get(num + 2) - 1);
                needs.put(num + 3, needs.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
            freqs.put(num, freqs.get(num) - 1);
        }
        return true;
    }
}
