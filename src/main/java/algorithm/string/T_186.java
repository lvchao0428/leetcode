package algorithm.string;


/**
 * @author chao lv
 *
 * 给你一个字符数组 s ，反转其中 单词 的顺序。
 *
 * 单词 的定义为：单词是一个由非空格字符组成的序列。s 中的单词将会由单个空格分隔。
 *
 * 必须设计并实现 原地 解法来解决此问题，即不分配额外的空间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * 输出：["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * 示例 2：
 *
 * 输入：s = ["a"]
 * 输出：["a"]
 *
 */
public class T_186 {
    public static void reverseWords(char[] s) {
        if (s.length == 1) {
            return;
        }
        int bIdx = 0;
        for (int i = 0; i < s.length; ++i) {
            if (s[i] == ' ') {
                reverse(s, bIdx, i-1);
                bIdx = i+1;
            }
        }
        if (bIdx != s.length) {
            reverse(s, bIdx, s.length-1);
        }
        reverse(s, 0, s.length-1);
    }

    public static void reverse(char[] s, int bIdx, int eIdx) {
        while (bIdx < eIdx) {
            swap(s, bIdx++, eIdx--);
        }
    }

    public static void swap(char[] s, int aIdx, int bIdx) {
        char tmp = s[aIdx];
        s[aIdx] = s[bIdx];
        s[bIdx] = tmp;
    }

    public static void main(String[] args) {
        char[] s = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(s);
        String ans = new String(s);
        System.out.println("reverseWords:" + ans);
    }
}
