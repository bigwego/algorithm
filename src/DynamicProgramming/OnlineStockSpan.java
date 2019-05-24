package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class OnlineStockSpan {

    List<Integer> dp;

    private final List<Integer> stocks;

    public OnlineStockSpan() {
        stocks = new ArrayList<>();
        dp = new ArrayList<>();
    }

    public int next(int price) {
        stocks.add(price);
        if (stocks.size() == 1) {
            dp.add(1);
        } else {
            if (stocks.get(stocks.size() - 2) <= price) {
                dp.add(dp.get(dp.size() - 1) + 1);
            } else {
                dp.add(1);
            }
        }
        return dp.get(dp.size() - 1);
    }
}
