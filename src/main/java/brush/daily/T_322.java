package brush.daily;

import java.util.Arrays;

/**
 *322. 零钱兑换
 * 中等
 * 2.6K
 * company
 * 亚马逊
 * company
 * 雅虎 Yahoo
 * company
 * 奥多比 Adobe
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * Created by charlielv on 2023.09.04.
 */
public class T_322 {
  public int coinChange(int[] coins, int amount) {
    int[] memo = new int[amount+1];
    Arrays.fill(memo, -666);
    return dp(coins, amount, memo);
  }

  public int dp(int[] coins, int amount, int[] memo) {
    if (amount == 0) {
      return 0;
    }
    if (amount < 0) {
      return -1;
    }
    if (memo[amount] != -666) {
      return memo[amount];
    }
    int res = Integer.MAX_VALUE;
    for (int coin : coins) {
      int subP = dp(coins, amount - coin, memo);
      if (subP == -1) {
        continue;
      }
      res = Math.min(res, subP + 1);
    }
    memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
    return memo[amount];
  }
}
