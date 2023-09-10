package mianshi;

/**
 * 给定数列W：w1, w2, w3, … , wn（可正可负），求连续一段区间和的最大值。
 *
 * Created by charlielv on 2023.09.08.
 */
public class T_Baidu_01 {

  /**
   * 冒泡排序，从小到大
   *
   * @param nums
   */
  public static void popSort(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n-1; ++i) {
      for (int j = 0; j < n-i-1; ++j) {
        if (nums[j] > nums[j+1]) {
          int tmp = nums[j];
          nums[j] = nums[j+1];
          nums[j+1] = tmp;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {3, 4, 5, 2, 1};
    popSort(nums);
    for (int i = 0; i < nums.length; ++i) {
      System.out.print(nums[i] + " ");
    }

  }
}
