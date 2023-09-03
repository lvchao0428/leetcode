package brush.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 1133. 最大唯一数
 * 提示
 * 简单
 * 18
 * company
 * 微软 Microsoft
 * company
 * 亚马逊
 * company
 * eBay
 * 给你一个整数数组 A，请找出并返回在该数组中仅出现一次的最大整数。
 *
 * 如果不存在这个只出现一次的整数，则返回 -1。
 *
 * Created by charlielv on 2023.09.03.
 */
public class T_1133 {
  public int largestUniqueNumber(int[] nums) {
    int ans = -1;
    Map<Integer, Integer> map = new HashMap<>();
    for (int x : nums) {
      if (!map.containsKey(x)) {
        map.put(x, 1);
      } else {
        map.put(x, map.get(x) + 1);
      }

    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        ans = Math.max(ans, entry.getKey());
      }
    }

    return ans;
  }
}
