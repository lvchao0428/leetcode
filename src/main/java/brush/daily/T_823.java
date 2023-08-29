package brush.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by charlielv on 2023-08-29.
 */
public class T_823 {
  public int numFactoredBinaryTrees(int[] arr) {
    Arrays.sort(arr);
    int n = arr.length;
    long[] dp = new long[n];
    long res = 0, mod = 1000000007;
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      for (int left = 0, right = i - 1; left <= right; left++) {
        while (right >= left && (long) arr[left] * arr[right] > arr[i]) {
          right--;
        }
        if (right >= left && (long) arr[left] * arr[right] == arr[i]) {
          if (right != left) {
            dp[i] = (dp[i] + dp[left] * dp[right] * 2) % mod;
          } else {
            dp[i] = (dp[i] + dp[left] * dp[right]) % mod;
          }
        }
      }
      res = (res + dp[i]) % mod;
    }
    return (int) res;
  }

  public int numFactoredBinaryTrees2(int[] arr) {
    final long MOD = (long)1e9 + 7;
    int n = arr.length;
    Arrays.sort(arr);
    Map<Integer, Integer> idxMap = new HashMap<>(n);
    for (int i = 0; i < n; ++i) {
      idxMap.put(arr[i], i);
    }
    long ans = 0;
    long[] memo = new long[n];
    Arrays.fill(memo, -1);
    for (int i = 0; i < n; ++i) {
      ans += dfs(i, arr, memo, idxMap);
    }
    return (int)(ans % MOD);
  }


  public long dfs(int i, int[] arr, long[] memo, Map<Integer, Integer> idxMap) {
    if (memo[i] != -1) {
      return memo[i];
    }
    int val = arr[i];
    long res = 1;
    for (int j = 0; j < i; ++j) {
      int x = arr[j];
      if (val % x == 0 && idxMap.containsKey(val / x)) {
        res += dfs(j, arr, memo, idxMap) * dfs(idxMap.get(val / x), arr, memo, idxMap);
      }
    }

    return memo[i] = res;
  }

}
