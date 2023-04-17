package algorithm.dp;

import java.util.Arrays;

public class D_322 {
  int[] memo;
  public int coinChange(int[] coins, int amount) {
    memo = new int[amount + 1];
    Arrays.fill(memo, -999);
    return dp(coins, amount);
  }

  public int dp(int[] coins, int amount) {
    if (amount == 0) return 0;
    if (amount < 0) return -1;
    if (memo[amount] != -999) {
      return memo[amount];
    }
    int res = Integer.MAX_VALUE;
    for (int c : coins) {
      int subP = dp(coins, amount - c);
      if (subP == -1) continue;
      res = Math.min(res, subP + 1);
    }
    memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
    return memo[amount];
  }
}
