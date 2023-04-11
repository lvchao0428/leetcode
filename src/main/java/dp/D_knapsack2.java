package dp;

/**
 * W : 每个钱包重量
 * N : 钱包数量
 * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]
 */
public class D_knapsack2 {
  int knapsack(int W, int N, int[] wt, int[] val) {
    assert N == wt.length;
    int[][] dp = new int[W+1][N+1];
    for (int i = 1; i <= N; ++i) {
      for (int w = 1; w <= W; ++w) {
        if (W - wt[i-1] < 0) {
          dp[i][w] = dp[i-1][w];
        } else {
          dp[i][w] = Math.max(dp[i-1][w-wt[i-1]] + val[i-1], dp[i-1][w]);
        }
      }
    }
    return dp[W][N];
  }
}
