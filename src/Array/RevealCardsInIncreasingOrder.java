package Array;

import java.util.Arrays;
import java.util.LinkedList;

public class RevealCardsInIncreasingOrder {

    public int[] deckRevealedIncreasing(int[] deck) {
        int len = deck.length;
        Arrays.sort(deck);
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            queue.add(i);
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }

        return res;
    }
}
