package brush.daily;

/**
 * @author chao lv
 *
 * 给定一个二进制数组 nums ，如果最多可以翻转一个 0 ，则返回数组中连续 1 的最大个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,1,1,0]
 * 输出：4
 * 解释：翻转第一个 0 可以得到最长的连续 1。
 *      当翻转以后，最大连续 1 的个数为 4。
 * 示例 2:
 *
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：4
 *
 *
 */
public class T_487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, counter = 0;
        for (int l = 0, r = 0; r < nums.length; ++r) {
            if (nums[r] == 0) {
                counter++;
                while (counter > 1) {
                    if (nums[l] == 0) {
                        counter--;
                    }
                    l++;
                }
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
