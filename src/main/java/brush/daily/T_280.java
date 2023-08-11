package brush.daily;

/**
 * Created by charlielv on 2023-08-11.
 *
 * 给你一个的整数数组 nums, 将该数组重新排序后使 nums[0] <= nums[1] >= nums[2] <= nums[3]...
 *
 * 输入数组总是有一个有效的答案。
 */
public class T_280 {
  public void wiggleSort(int[] nums) {
    int[] taken = new int[nums.length];
    int j = 0;
    boolean bigger = false;

    for (int i = 0; i < nums.length-1; ++i) {
      if (bigger) {
        if (nums[i] < nums[i+1]) {
          int tmp = nums[i];
          nums[i] = nums[i+1];
          nums[i+1] = tmp;
        }
      } else {
        if (nums[i] > nums[i+1]) {
          int tmp = nums[i];
          nums[i] = nums[i+1];
          nums[i+1] = tmp;
        }
      }
      bigger = !bigger;
    }
  }
}
