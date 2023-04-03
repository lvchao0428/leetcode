package graph;

import java.util.LinkedList;
import java.util.List;

public class G_797 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      LinkedList<Integer> path = new LinkedList<>();
    traverse(graph, 0, path);
    return res;
  }

  public void traverse(int[][] graph, int s, LinkedList<Integer> path) {
    path.addLast(s);
    int n = graph.length;
    if (s == n-1) {
      res.add(new LinkedList<Integer>(path));
    }
    for (int v : graph[s]) {
      traverse(graph, v, path);
    }
    path.removeLast();
  }
}
