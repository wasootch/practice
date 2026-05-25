package org.example.arrays;

public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int maxProfit = 0;
        int i = 0;
        int j = 1;
        int min = prices[0];
        while (i < prices.length - 1 && j < prices.length) {
            int left = prices[i];
            int right = prices[j];
            if (right < min) {
                min = right;
                i = j;
                j++;
            } else {
                int profit = right - left;

                if (profit < 0) {
                    if (min < left) {

                    }
                    i++;
                    j = i + 1;
                } else {
                    j++;
                }

                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
