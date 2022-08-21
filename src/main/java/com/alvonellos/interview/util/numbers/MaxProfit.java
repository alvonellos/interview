package com.alvonellos.interview.util.numbers;


import static java.lang.Math.max;
import static java.lang.Math.min;

public class MaxProfit {

    /**
     * Given an array of prices, find the maximum profit you can make from buying and selling one share of the stock.
     * @param prices an array of prices
     * @return the maximum profit you can make from buying and selling one share of the stock
     * NOTE: This method is too slow and is the naive solution.
     */
    public static int maxProfitBF(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int j = i;
            while(j < prices.length) {
                maxProfit = max(maxProfit, prices[j] - prices[i]);
                j++;
            }
        }
        return maxProfit;
    }

    /**
     * Calculates the maximum profit from a given array of prices.
     * @param prices the array of prices
     * @return the maximum profit
     * NOTE: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = min(minPrice, prices[i]);
            maxProfit = max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

}
