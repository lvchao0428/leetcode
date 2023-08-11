package brush.daily;

/**
 * Created by charlielv on 2023-08-11.
 *
 * 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
 *
 * 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 */
public class T_1289 {
  public int minFallingPathSum(int[][] grid) {
    // dp 问题
    int n = grid.length;
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        dp[i][j] = Integer.MAX_VALUE;
      }
    }
    for (int i = 0; i < n; ++i) {
      dp[0][i] = grid[0][i];
    }
    for (int i = 1; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        for (int k = 0; k < n; ++k) {
          if (j == k) {
            continue;
          }
          dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + grid[i][j]);
        }
      }
    }

    int res = Integer.MAX_VALUE;
    for (int i = 0; i < n; ++i) {
      res = Math.min(res, dp[n-1][i]);
    }

    return res;
  }
}
