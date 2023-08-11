package brush.daily;

/**
 * Created by charlielv on 2023-08-11.
 *
 * 1572. 矩阵对角线元素的和
 * 提示
 * 简单
 * 94
 * company
 * 亚马逊
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 *
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 */
public class T_1572 {
  public int diagonalSum(int[][] mat) {
    int res = 0;
    int n = mat.length;
    for (int i = 0; i < n; ++i) {
      res += mat[i][i];
      if (i == n-1-i) {
        continue;
      }
      res += mat[i][n-1-i];
    }

    return res;
  }
}
