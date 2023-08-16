package brush.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chao lv
 *
 * 给你一个字符串 s 和一个整数 k ，请你找出 至多 包含 k 个 不同 字符的最长子串，并返回该子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "eceba", k = 2
 * 输出：3
 * 解释：满足题目要求的子串是 "ece" ，长度为 3 。
 * 示例 2：
 *
 * 输入：s = "aa", k = 1
 * 输出：2
 * 解释：满足题目要求的子串是 "aa" ，长度为 2 。
 *
 */
public class T_340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int sLen = s.length();
        if (k >= sLen) {
            return sLen;
        }
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int l = 0, r = 0; r < sLen; ++r) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            while (map.size() > k) {
                char leftChar = s.charAt(l++);
                int value = map.get(leftChar) - 1;
                if (value == 0) {
                    map.remove(leftChar);
                } else {
                    map.put(leftChar, value);
                }
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
