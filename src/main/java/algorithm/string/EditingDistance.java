package algorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chao lv
 *
 * 编辑距离。
 * minCost1 : 递归解法，无备忘录。
 * minCost2 : 递归解法，带备忘录。
 * minCost3 : 迭代， DP table 解法。
 */
public class EditingDistance {

    public static int minCost1(char[] cc1, int i1, char[] cc2, int i2) {

        if (i1 == -1) {
            return i1+1;
        }
        if (i2 == -1) {
            return i2+2;
        }
        if (cc1[i1] == cc2[i2]) {
            return minCost1(cc1, i1-1, cc2, i2-1);
        } else {
            return Math.min(minCost1(cc1, i1, cc2, i2-1) + 1,
                    Math.min(minCost1(cc1, i1-1, cc2, i2) + 1, minCost1(cc1, i1-1, cc2, i2-1) + 1));
        }
    }

    public static int minCost2(char[] cc1, int i1, char[] cc2, int i2, Map<String, Integer> memo) {
        if (i1 == -1) {
            return i1 + 1;
        }
        if (i2 == -1) {
            return i2 + 1;
        }
        String memoKey = cc1[i1] + "_" + cc2[i2];
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }
        if (cc1[i1] == cc2[i2]) {
            memo.putIfAbsent(memoKey, minCost2(cc1, i1-1, cc2, i2-1, memo));
        } else {
            memo.putIfAbsent(memoKey,
                    Math.min(minCost2(cc1, i1, cc2, i2-1, memo)+1,
                    Math.min(minCost2(cc1, i1-1, cc2, i2, memo) + 1,
                            minCost2(cc1, i1-1, cc2, i2-1, memo) + 1)));

        }

        return memo.get(memoKey);
    }

    public static int minCost3(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; ++i) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; ++j) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }  else {
                    dp[i][j] = min(dp[i][j-1] + 1, dp[i-1][j] + 1, dp[i-1][j-1] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        Map<String, Integer> memo = new HashMap<>();
        System.out.println("min cost1:" + minCost1(s1.toCharArray(), s1.length()-1, s2.toCharArray(), s2.length()-1));
        System.out.println("min cost2:" + minCost2(s1.toCharArray(), s1.length()-1, s2.toCharArray(), s2.length()-1, memo));
        System.out.println("min Cost3:" + minCost3(s1, s2));
    }
}
