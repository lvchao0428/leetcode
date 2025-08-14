package algorithm.math;

/**
 * Created by charlielv on 20250814.
 */
public class SquareSimilar {
  /**
   * 初始值：double ret = x; 以自身作为平方根的初始近似值
   * 循环条件：Math.abs(ret - x/ret) > e * ret
   * 这个条件判断当前近似值是否足够精确。当两次迭代结果的差异小于精度 e 与当前值的乘积时，停止迭代。
   * 迭代公式：ret = (ret + x/ret)/2.0;
   * 这是牛顿迭代法求平方根的核心公式。对于求√x，每次迭代都让近似值更接近真实值。
   * 牛顿迭代法原理：
   * 要求 x 的平方根，等价于求方程 f(ret) = ret² - x = 0 的解。
   * 牛顿迭代公式为：retₙ₊₁ = retₙ - f(retₙ)/f'(retₙ)
   * 代入 f (ret) 和其导数 f'(ret) = 2ret，可得：retₙ₊₁ = (retₙ + x/retₙ)/2
   * 这正是代码中使用的迭代公式。
   * 
   * @param x
   * @param e
   * @return
   */
  public static double square(int x, double e) {
    double ret = x;
    while (Math.abs(ret - x/ret) > e * ret) {
      ret = (ret + x/ret)/2.0;
    }

    return ret;
  }

  public static void main(String[] args) {
    int x = 9;
    double e = 1e-6;
    double ret = square(x, e);
    System.out.println("ret:" + ret);
  }
}
