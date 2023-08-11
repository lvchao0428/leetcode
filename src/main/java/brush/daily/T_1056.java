package brush.daily;

/**
 * Created by charlielv on 2023-08-11.
 *
 * 给定一个数字 N，当它满足以下条件的时候返回 true：
 *
 * 原数字旋转 180° 以后可以得到新的数字。
 *
 * 如 0, 1, 6, 8, 9 旋转 180° 以后，得到了新的数字 0, 1, 9, 8, 6 。
 *
 * 2, 3, 4, 5, 7 旋转 180° 后，得到的不是数字。
 *
 * 易混淆数 (confusing number) 在旋转180°以后，可以得到和原来不同的数，且新数字的每一位都是有效的。
 *
 *
 */
public class T_1056 {
  public boolean confusingNumber(int n) {
    int[] arr = new int[]{0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
    int sum = 0, newN = n;
    while (n != 0) {
      int div = n % 10;
      if (arr[div] == -1) {
        return false;
      }
      sum = sum*10 + arr[div];
      n /= 10;
    }

    if (sum == newN) {
      return false;
    }

    return true;
  }
}
