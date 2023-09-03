package brush.daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1198. 找出所有行中最小公共元素
 * 提示
 * 中等
 * 31
 * company
 * 亚马逊
 * company
 * 微软 Microsoft
 * company
 * 完美世界
 * 给你一个 m x n 的矩阵 mat，其中每一行的元素均符合 严格递增 。请返回 所有行中的 最小公共元素 。
 *
 * 如果矩阵中没有这样的公共元素，就请返回 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
 * 输出：5
 * 示例 2:
 *
 * 输入：mat = [[1,2,3],[2,3,4],[2,3,5]]
 * 输出： 2
 *
 * Created by charlielv on 2023.09.03.
 */
public class T_1198 {
  public int smallestCommonElement(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < m; ++i) {
      Set<Integer> tmpSet = new HashSet<>();
      for (int j = 0; j < n; ++j) {
        tmpSet.add(mat[i][j]);
      }
      for (int x : tmpSet) {
        map.put(x, map.getOrDefault(x, 0) + 1);
      }
    }
    int ans = -1;
    int minV = 10001;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == m) {
        minV = Math.min(minV, entry.getKey());
      }
    }
    if (minV != 10001) {
      ans = minV;
    }
    return ans;
  }
}
