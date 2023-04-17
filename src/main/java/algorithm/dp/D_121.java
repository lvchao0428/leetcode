package algorithm.dp;

public class D_121 {
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int[][] dp = new int[n][2];
    for (int i = 0; i < n; ++i) {
      if (i-1 == -1) {
        dp[i][0] = 0;
        dp[i][1] = -prices[i];
      } else {
        dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
        dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
      }
    }
    return dp[n-1][0];
  }
}
