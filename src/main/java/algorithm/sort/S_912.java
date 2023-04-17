package algorithm.sort;

public class S_912 {
  public static int[] tmp;
  public int[] sortArray(int[] nums) {
    tmp = new int[nums.length];
    sort(nums, 0, nums.length-1);
    return nums;
  }

  public void sort(int[] nums, int lo, int hi) {
    if (lo == hi) {
      return;
    }
    int mid = lo + (hi - lo)/2;
    sort(nums, lo, mid);
    sort(nums, mid+1, hi);
    merge(nums, lo, mid, hi);
  }

  public void merge(int[] nums, int lo, int mid, int hi) {
    for (int i = lo; i <= hi; ++i) {
      tmp[i] = nums[i];
    }
    int i = lo, j = mid+1;
    for (int p = lo; p <= hi; ++p) {
      if (i == mid+1) {
        nums[p] = tmp[j++];
      } else if (j == hi+1) {
        nums[p] = tmp[i++];
      } else if (tmp[i] < tmp[j]) {
        nums[p] = tmp[i++];
      } else if (tmp[i] >= tmp[j]) {
        nums[p] = tmp[j++];
      }
    }
  }
}
