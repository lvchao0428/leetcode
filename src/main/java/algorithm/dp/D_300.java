package algorithm.dp;

import java.util.Arrays;

public class D_300 {
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays. fill(dp, 1);
    for (int i = 0; i < nums.length; ++i) {
      for (int j = 0; j < i; ++j) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j]+1);
        }
      }
    }
    int res = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; ++i) {
      res = Math.max(res, dp[i]);
    }

    return res;
  }
}
