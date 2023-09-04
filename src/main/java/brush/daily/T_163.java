package brush.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *163. 缺失的区间
 * 简单
 * 110
 * company
 * Facebook
 * 给你一个闭区间 [lower, upper] 和一个 按从小到大排序 的整数数组 nums ，其中元素的范围在闭区间 [lower, upper] 当中。
 *
 * 如果一个数字 x 在 [lower, upper] 区间内，并且 x 不在 nums 中，则认为 x 缺失。
 *
 * 返回 准确涵盖所有缺失数字 的 最小排序 区间列表。也就是说，nums 的任何元素都不在任何区间内，并且每个缺失的数字都在其中一个区间内。
 *
 *
 * 示例 1：
 *
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 , upper = 99
 * 输出: [[2,2],[4,49],[51,74],[76,99]]
 * 解释：返回的区间是：
 * [2,2]
 * [4,49]
 * [51,74]
 * [76,99]
 * 示例 2：
 *
 * Created by charlielv on 2023.09.04.
 */
public class T_163 {
  public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
    List<List<Integer>> ans = new ArrayList<>();
    for (int x : nums) {
      if (lower < x) {
        ans.add(Arrays.asList(lower, x-1));
      }
      lower = x+1;
    }
    if (lower <= upper) {
      ans.add(Arrays.asList(lower, upper));
    }
    return ans;
  }
}
