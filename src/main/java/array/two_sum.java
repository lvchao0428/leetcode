package array;

import java.util.HashMap;

public class two_sum {

  public class Sol1 {
    /**
     *  46/57 pass
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

      HashMap<Integer, Integer> im = new HashMap<>();
      im.put(nums[0], 0);
      int[] res = new int[2];
      for (int i = 1; i < nums.length; ++i) {
        if (im.containsKey(target - nums[i])) {
          res[0] = im.get(target - nums[i]);
          res[1] = i;
          break;
        } else {
          im.put(target - nums[i], i);
        }
      }

      return res;
    }
  }

  public class Sol2{
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> im = new HashMap<>();
      int[] res = new int[2];
      for (int i = 0,j = nums.length-1; i <= j; ++i,--j) {
        if (nums[i] + nums[j] == target) {
          res[0] = i;
          res[1] = j;
          break;
        }
        int tmp = target-nums[i];
        if (im.containsKey(tmp)) {
          int index = im.get(tmp);
          return new int[]{Math.min(i, index), Math.max(i, index)};
        }
        tmp = target-nums[j];
        if (im.containsKey(tmp)) {
          int index = im.get(tmp);
          return new int[]{Math.min(j, index), Math.max(j, index)};
        }
        im.put(nums[i], i);
        im.put(nums[j], j);
      }
      return res;
    }
  }

}

