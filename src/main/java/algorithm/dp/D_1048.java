package algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class D_1048 {
  Map<String, Integer> cntMap = new HashMap<>();
  public int longestStrChain(String[] words) {
    int res = 0;
    Arrays.sort(words, (a, b) -> a.length() - b.length());
    for (String word : words) {
      cntMap.put(word, 1);
      for (int i = 0; i < word.length(); ++i) {
        String pre = word.substring(0, i) + word.substring(i+1);
        if (cntMap.containsKey(pre)) {
          cntMap.put(word, Math.max(cntMap.get(word), cntMap.get(pre) +1));
        }
      }
      res = Math.max(res, cntMap.get(word));
    }

    return res;
  }
}
