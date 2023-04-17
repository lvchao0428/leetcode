package algorithm.graph;

import java.util.LinkedList;
import java.util.List;

public class G_207 {
  boolean hasCycle;
  boolean[] visited, onPath;

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Integer>[] graph = buildGraph(numCourses, prerequisites);
    visited = new boolean[numCourses];
    onPath = new boolean[numCourses];
    for (int i = 0; i < numCourses; ++i) {
      traverse(graph, i);
    }

    return !hasCycle;
  }

  public void traverse(List<Integer>[] graph, int s) {
    if (onPath[s]) {
      hasCycle = true;
    }
    if (visited[s] || onPath[s]) {
      return;
    }
    visited[s] = true;
    onPath[s] = true;
    for (int edge : graph[s]) {
      traverse(graph, edge);
    }
    onPath[s] = false;
  }

  public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
    LinkedList<Integer>[] graph = new LinkedList[numCourses];
    for (int i = 0; i < numCourses; ++i) {
      graph[i] = new LinkedList<Integer>();
    }
    for (int[] edge : prerequisites) {
      int from = edge[0], to = edge[1];
      graph[from].add(to);
    }

    return graph;
  }
}
