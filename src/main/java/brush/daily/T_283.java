package brush.daily;

/**
 * 283. 移动零
 * 提示
 * 简单
 * 2.2K
 * company
 * Facebook
 * company
 * 亚马逊
 * company
 * 谷歌 Google
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 *
 * Created by charlielv on 2023.09.08.
 */
public class T_283 {
  public void moveZeroes(int[] nums) {
    int zeroIdx = removeElement(nums, 0);
    for (; zeroIdx < nums.length; ++zeroIdx) {
      nums[zeroIdx] = 0;
    }
  }

  public int removeElement(int[] nums, int val) {
    int slow = 0, fast = 0;
    while (fast < nums.length) {
      if (nums[fast] != val) {
        nums[slow] = nums[fast];
        slow++;
      }
      fast++;
    }
    return slow;
  }
}
