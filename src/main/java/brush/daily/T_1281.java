package brush.daily;

/**
 * Created by charlielv on 2023-08-10.
 *
 * 1281. 整数的各位积和之差
 * 提示
 * 简单
 * 152
 * company
 * 奥多比 Adobe
 * company
 * 微软 Microsoft
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 *
 */
public class T_1281 {
  public int subtractProductAndSum(int n) {
    int multiQuota = 1;
    int sumQuota = 0;
    while (n > 0) {
      int quota = n % 10;
      n /= 10;
      multiQuota *= quota;
      sumQuota += quota;
    }
    return multiQuota - sumQuota;
  }

}
