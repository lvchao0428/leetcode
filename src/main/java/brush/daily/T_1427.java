package brush.daily;

/**
 * Created by charlielv on 2023-08-11.
 *
 * 给定一个包含小写英文字母的字符串 s 以及一个矩阵 shift，其中 shift[i] = [direction, amount]：
 *
 * direction 可以为 0 （表示左移）或 1 （表示右移）。
 * amount 表示 s 左右移的位数。
 * 左移 1 位表示移除 s 的第一个字符，并将该字符插入到 s 的结尾。
 * 类似地，右移 1 位表示移除 s 的最后一个字符，并将该字符插入到 s 的开头。
 * 对这个字符串进行所有操作后，返回最终结果。
 */
public class T_1427 {
  public String stringShift(String s, int[][] shift) {
    char[] sAry = s.toCharArray();
    for (int i = 0; i < shift.length; ++i) {
      int rotate = shift[i][0];
      int rotateNum = shift[i][1];
      if (rotate == 0) {
        leftShift(sAry, rotateNum);
      }
      if (rotate == 1) {
        rightShift(sAry, rotateNum);
      }
    }
    return new String(sAry);
  }

  public void leftShift(char[] ary, int rotateNum) {
    char[] tmp = new char[ary.length*2];
    int j = 0;
    for (int i = 0; i < ary.length*2; ++i) {
      tmp[i] = ary[j++];
      if (j == ary.length) {
        j = 0;
      }
    }
    j = rotateNum % ary.length;
    for (int i = 0; i < ary.length; ++i) {
      ary[i] = tmp[j++];
    }
  }

  public void rightShift(char[] ary, int rotateNum) {
    char[] tmp = new char[ary.length*2];
    int j = 0;
    for (int i = 0; i < ary.length*2; ++i) {
      tmp[i] = ary[j++];
      if (j == ary.length) {
        j = 0;
      }
    }
    j = ary.length - rotateNum % ary.length;
    for (int i = 0; i < ary.length; ++i) {
      ary[i] = tmp[j++];
    }
  }
}
