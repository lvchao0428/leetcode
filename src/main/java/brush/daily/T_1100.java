package brush.daily;

/**
 * @author chao lv
 *
 * 给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "havefunonleetcode", K = 5
 * 输出：6
 * 解释：
 * 这里有 6 个满足题意的子串，分别是：'havef','avefu','vefun','efuno','etcod','tcode'。
 * 示例 2：
 *
 * 输入：S = "home", K = 5
 * 输出：0
 * 解释：
 * 注意：K 可能会大于 S 的长度。在这种情况下，就无法找到任何长度为 K 的子串。
 *
 *
 */
public class T_1100 {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int sLen = s.length();
        int res = 0;
        if (k > sLen || k > 26) {
            return res;
        }
        for (int r = 0; r <= sLen - k; r++) {
            int[] freq = new int[26];
            boolean isUniq = true;
            for (int l = r; l < r+k; ++l) {
                char c = s.charAt(l);
                freq[c - 'a']++;
                if (freq[c - 'a'] > 1) {
                    isUniq = false;
                    break;
                }
            }

            if (isUniq) {
                res++;
            }
        }


        return res;
    }
}
