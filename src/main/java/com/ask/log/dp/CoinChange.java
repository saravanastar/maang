package com.ask.log.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * ou are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {
    int[] coins;
    Map<String, Integer> lookup = new HashMap<>();

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1,2,5}, 11));
    }
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        return dp(0, amount, 0);
    }

    /**
     *  curr
     * @param index
     * @param remainingCost
     * @return
     */
    public int dp(int index, int remainingCost, int length) {
        if (remainingCost < 0 || index >= coins.length) return Integer.MAX_VALUE;
        if (remainingCost == 0) {
            return length;
        }
        String key = getKey(index, remainingCost);
        if (lookup.containsKey(key)) return lookup.get(key);
        int min = Math.min(dp(index, remainingCost - coins[index], length + 1),
                dp(index + 1, remainingCost, length));
        int result =  Math.min(min, dp(index + 1, remainingCost - coins[index], length + 1));
        lookup.put(getKey(index, remainingCost), result);
        return result;
    }

    private String getKey(final int index, final int remainingCost) {
        return index + "" + remainingCost;
    }
}
