package brush.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * 1426. 数元素
 * 提示
 * 简单
 * 12
 * company
 * 蔚来
 * company
 * 特斯拉
 * 给你一个整数数组 arr， 对于元素 x ，只有当 x + 1 也在数组 arr 里时，才能记为 1 个数。
 *
 * 如果数组 arr 里有重复的数，每个重复的数单独计算。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3]
 * 输出：2
 * 解释：1 和 2 被计算次数因为 2 和 3 在数组 arr 里。
 * 示例 2：
 *
 * 输入：arr = [1,1,3,3,5,5,7,7]
 * 输出：0
 * 解释：所有的数都不算, 因为数组里没有 2、4、6、8。
 *
 * 1426. 数元素
 * 提示
 * 简单
 * 12
 * company
 * 蔚来
 * company
 * 特斯拉
 * 给你一个整数数组 arr， 对于元素 x ，只有当 x + 1 也在数组 arr 里时，才能记为 1 个数。
 *
 * 如果数组 arr 里有重复的数，每个重复的数单独计算。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3]
 * 输出：2
 * 解释：1 和 2 被计算次数因为 2 和 3 在数组 arr 里。
 * 示例 2：
 *
 * 输入：arr = [1,1,3,3,5,5,7,7]
 * 输出：0
 * 解释：所有的数都不算, 因为数组里没有 2、4、6、8。
 *
 * Created by charlielv on 2023.09.03.
 */
public class T_1426 {
  public int countElements(int[] arr) {
    int ans = 0;
    Set<Integer> set = new HashSet<>();
    for (int x : arr) {
      set.add(x);
    }
    for (int x : arr) {
      if (set.contains(x + 1)) {
        ans++;
      }
    }
    return ans;
  }
}
