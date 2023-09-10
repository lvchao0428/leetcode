package brush.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Created by charlielv on 2023.09.10.
 */
public class T_797 {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    traverse(graph, 0, path, ans);
    return ans;
  }

  public void traverse(int[][] graph, int s, LinkedList<Integer> path, List<List<Integer>> ans) {
    path.addLast(s);
    int n = graph.length;
    if (s == n-1) {
      ans.add(new LinkedList<>(path));
      path.removeLast();
      return;
    }

    for (int v : graph[s]) {
      traverse(graph, v, path, ans);
    }

    path.removeLast();
  }
}
