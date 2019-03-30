package HashTable;

import java.util.HashSet;

public class DistributeCandies {

    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return set.size() >= candies.length / 2 ? candies.length / 2 : set.size();
    }
}
