package algorithm.backtrace;

import java.util.LinkedList;
import java.util.List;

public class demo {
  public static List<List<Integer>> res = new LinkedList<>();
  public static LinkedList<Integer> track = new LinkedList<>();

  // 元素无重可复选的全排列
  public static List<List<Integer>> permuteRepeat(int[] nums) {
    backtrack(nums);
    return res;
  }

  // 回溯算法核心函数
  public static void backtrack(int[] nums) {
    // base case，到达叶子节点
    if (track.size() == nums.length) {
      // 收集根到叶子节点路径上的值
      res.add(new LinkedList(track));
      return;
    }

    // 回溯算法标准框架
    for (int i = 0; i < nums.length; i++) {
      // 做选择
      track.add(nums[i]);
      // 进入下一层回溯树
      backtrack(nums);
      // 取消选择
      track.removeLast();
    }
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    backtrack(nums);
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < res.size(); ++i) {
      StringBuilder sbr = new StringBuilder();
      for (int j = 0; j < res.get(i).size(); ++j) {
        sbr.append(res.get(i).get(j));
      }
      ans.append(sbr.toString() + ",");
    }
    System.out.println(ans);
  }
}
