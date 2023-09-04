package brush.daily;

import java.util.Arrays;

/**
 * 253. 会议室 II
 * 提示
 * 中等
 * 550
 * company
 * 谷歌 Google
 * company
 * 亚马逊
 * company
 * Facebook
 * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，返回 所需会议室的最小数量 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：2
 * 示例 2：
 *
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：1
 *
 * Created by charlielv on 2023.09.04.
 */
public class T_253 {
  public int minMeetingRooms(int[][] intervals) {
    int n = intervals.length;
    int[] begin = new int[n];
    int[] end = new int[n];
    for (int i = 0; i < n; ++i) {
      begin[i] = intervals[i][0];
      end[i] = intervals[i][1];
    }
    Arrays.sort(begin);
    Arrays.sort(end);
    int count = 0;
    int ans = 0, i = 0, j = 0;
    while (i < n && j < n) {
      if (begin[i] < end[j]) {
        count++;
        i++;
      } else {
        count--;
        j++;
      }
      ans = Math.max(ans, count);
    }

    return ans;
  }
}
