package backtrace;

import java.util.LinkedList;
import java.util.List;

public class B_140 {
  LinkedList<String> res = new LinkedList<>();
  LinkedList<String> traces = new LinkedList<>();
  public List<String> wordBreak(String s, List<String> wordDict) {
    trace(s, 0, wordDict);
    return res;
  }

  public void trace(String s, int i, List<String> wordDict) {
    if (i == s.length()) {
      res.add(String.join(" ", traces));
      return;
    }
    if (i > s.length()) {
      return;
    }
    for (String word : wordDict) {
      int len = word.length();
      if (i + len > s.length()) {
        continue;
      }
      String subStr = s.substring(i, i + len);
      if (!word.equals(subStr)) {
        continue;
      }
      traces.add(word);
      trace(s, i + len, wordDict);
      traces.removeLast();
    }
  }
}
