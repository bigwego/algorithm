package DynamicProgramming;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0], res = 0;
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        int min = prices[0], res = 0;
        for (int i = 1, len = prices.length; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                res = Math.max(res, prices[i] - min);
            }
        }

        return res;
    }
}
