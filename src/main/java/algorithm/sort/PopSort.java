package algorithm.sort;

/**
 * 冒泡排序
 *
 * Created by charlielv on 2023.09.08.
 */
public class PopSort {
  public static void sort(int[] nums) {
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
    int[] nums = new int[]{3, 2, 1};
    sort(nums);
    for (int i = 0; i < nums.length; ++i) {
      System.out.print(nums[i] + " ");
    }
  }
}
