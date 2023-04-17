package algorithm.dp;

import java.util.Arrays;

public class D_213 {

  private int[] memo1;
  private int[] memo2;
  public int rob(int[] nums) {
    int n = nums.length;
    if (n==1) return nums[0];
    memo1 = new int[n];
    memo2 = new int[n];
    Arrays.fill(memo1, -1);
    Arrays.fill(memo2, -1);
    return Math.max(dp(nums, 0, n-2, memo1),
        dp(nums, 1, n-1, memo2));
  }

  private int dp(int[] nums, int start, int end, int[] memo) {
    if (start > end) {
      return 0;
    }
    if (memo[start] != -1) {
      return memo[start];
    }
    int res = Math.max(dp(nums, start+1, end, memo),
        dp(nums, start+2, end, memo) + nums[start]);
    memo[start] = res;
    return res;
  }
}
