package brush.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 中等
 * 1.8K
 * company
 * 亚马逊
 * company
 * 谷歌 Google
 * company
 * 奥多比 Adobe
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 
 * Created by charlielv on 2023.09.03.
 */
public class T_128 {
  public int longestConsecutive(int[] nums) {
    int ans = 0;
    Set<Integer> set = new HashSet<>();
    for (int x : nums) {
      set.add(x);
    }
    for (int x : set) {
      if (set.contains(x - 1)) {
        continue;
      }
      int curNum = x;
      int curLen = 1;
      while (set.contains(curNum+1)) {
        curNum++;
        curLen++;
      }
      ans = Math.max(ans, curLen);
    }
    return ans;
  }
}
