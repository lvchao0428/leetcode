package dp;

import java.util.Arrays;

public class D_931 {

  public class Func1 {
    public int minFallingPathSum(int[][] matrix) {
      int N = matrix.length;
      for (int c = N-2; c >= 0; --c) {
        for (int r = 0; r < N; ++r) {
          int best = matrix[r+1][c];
          if (c > 0) {
            best = Math.min(best, matrix[r+1][c-1]);
          }
          if (c + 1 < N) {
            best = Math.min(best, matrix[r+1][c+1]);
          }
          matrix[c][r] += best;
        }
      }

      int res = Integer.MAX_VALUE;
      for (int x : matrix[0]) {
        res = Math.min(res, x);
      }

      return res;
    }

  }

  public class Func2 {
    public int [][] memo;
    public int minFallingPathSum_fun2(int[][] matrix) {
      int n = matrix.length;
      memo = new int[n][n];
      for (int i = 0; i < n; ++i) {
        Arrays.fill(memo[i], 9999);
      }
      int res = Integer.MAX_VALUE;
      for (int j = 0; j < n; ++j) {
        res = Math.min(res, dp(matrix, n-1, j));
      }
      return res;
    }

    public int dp(int[][] matrix, int i, int j) {
      if (i < 0 || j < 0 || i >= matrix.length || j >= matrix.length) {
        return 9999;
      }
      if (i == 0) {
        return memo[0][j];
      }
      if (memo[i][j] != 9999) {
        return memo[i][j];
      }
      memo[i][j] = matrix[i][j] + min(
          dp(matrix, i-1, j-1),
          dp(matrix, i-1, j),
          dp(matrix, i-1, j+1)
      );

      return memo[i][j];
    }

    public int min(int a, int b, int c) {
      return Math.min(a, Math.min(b, c));
    }
  }

}
