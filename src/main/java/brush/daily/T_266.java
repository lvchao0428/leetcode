package brush.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
 *
 * 示例 1：
 *
 * 输入: "code"
 * 输出: false
 * 示例 2：
 *
 * 输入: "aab"
 * 输出: true
 * 示例 3：
 *
 * 输入: "carerac"
 * 输出: true
 *
 * Created by charlielv on 2023-08-29.
 */
public class T_266 {
  public boolean canPermutePalindrome(String s) {
    char[] chr = s.toCharArray();
    HashMap<Character, Integer> counter = new HashMap<>();
    int oddNum = 0;
    for (char c : chr) {
      if (!counter.containsKey(c)) {
        counter.put(c, 1);
      } else {
        counter.put(c, counter.get(c) + 1);
      }
    }

    for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
      if (entry.getValue() % 2 == 1) {
        oddNum++;
      }
    }

    if (oddNum > 1) {
      return false;
    }
    return true;
  }
}
