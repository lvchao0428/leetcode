package brush.daily;

import java.util.HashMap;

/**
 * @author chao lv
 *
 * 给你一个字符串 s ，请你找出 至多 包含 两个不同字符 的最长子串，并返回该子串的长度。
 *
 *
 * 示例 1：
 *
 * 输入：s = "eceba"
 * 输出：3
 * 解释：满足题目要求的子串是 "ece" ，长度为 3 。
 * 示例 2：
 *
 * 输入：s = "ccaabbb"
 * 输出：5
 * 解释：满足题目要求的子串是 "aabbb" ，长度为 5 。
 *
 *
 */
public class T_159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int l = 0, r = 0; r < s.length(); ++r) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            while (map.size() > 2) {
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
