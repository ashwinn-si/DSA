class Solution {
  boolean isFound;

  void dfs(int currEdge, List<Integer>[] graph, int n, int m, int colors[]) {
    if (currEdge == n) {
      isFound = true;
      return;
    }
    if (isFound) {
      return;
    }
    for (int color = 1; color <= m; color++) {
      // i am going to check if i can give this color or not ?
      boolean canGiveFlag = true;
      for (int adjEdge : graph[currEdge]) {
        if (colors[adjEdge] == color) {
          canGiveFlag = false;
          break;
        }
      }
      if (canGiveFlag) {
        colors[currEdge] = color;
        dfs(currEdge + 1, graph, n, m, colors);
        if (isFound)
          return;
        colors[currEdge] = 0;
      }
    }
  }

  boolean graphColoring(int[][] edges, int m, int n) {
    // your code goes here
    List<Integer>[] graph = new List[n];
    isFound = false;

    for (int index = 0; index < n; index++) {
      graph[index] = new ArrayList<>();
    }

    for (int edge[] : edges) {
      graph[edge[0]].add(edge[1]);
      graph[edge[1]].add(edge[0]);
    }

    dfs(0, graph, n, m, new int[n]);

    return isFound;
  }
}