package algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nsum_four {

  public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      Arrays.sort(nums);
      return nsum(nums, 4, 0, target);
    }

    public List<List<Integer>> nsum(int[] nums, int n, int start, long target) {
      List<List<Integer>> res = new ArrayList<>();
      int sz = nums.length;
      if (n < 2 || sz < n) return res;
      if (n == 2) {
        int lo = start, hi = sz - 1;
        while (lo < hi) {
          int left = nums[lo], right = nums[hi];
          long sum = (long) left + (long) right;
          if (sum == target) {
            res.add(new ArrayList<>(Arrays.asList(left, right)));
            while (lo < hi && nums[lo] == left) lo++;
            while (lo < hi && nums[hi] == right) hi--;
          } else if (sum < target) {
            while (lo < hi && nums[lo] == left) lo++;
          } else if (sum > target) {
            while (lo < hi && nums[hi] == right) hi--;
          }
        }
      } else {
        for (int i = start; i < sz; ++i) {
          List<List<Integer>> sub = nsum(nums, n - 1, i + 1, target - nums[i]);
          for (List<Integer> x : sub) {
            x.add(nums[i]);
            res.add(x);
          }
          while (i < sz - 1 && nums[i] == nums[i + 1]) i++;
        }
      }
      return res;
    }
  }
}
