package DFS;

import java.util.ArrayList;
import java.util.List;

public class ShoppingOffers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return help(0, price, special, needs);
    }

    private int help(int pos, List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int min = getDirectSum(price, needs);
        for (int i = pos, size1 = special.size(); i < size1; i++) {
            List<Integer> bag = special.get(i);
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0, size2 = needs.size(); j < size2; j++) {
                if (bag.get(j) > needs.get(j)) {
                    tmp = null;
                    break;
                }
                tmp.add(needs.get(j) - bag.get(j));
            }
            if (tmp != null) {
                min = Math.min(min, bag.get(bag.size() - 1) + help(i, price, special, tmp));
            }
        }
        return min;
    }

    private int getDirectSum(List<Integer> price, List<Integer> needs) {
        int sum = 0;
        for (int i = 0, size = needs.size(); i < size; i++) {
            sum += price.get(i) * needs.get(i);
        }
        return sum;
    }
}
