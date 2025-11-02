class Solution {
  Boolean isSafe[];

  // dfs returns true if node is safe (no cycle reachable from node)
  boolean dfs(int node, int[][] graph, int[] color) {
    if (isSafe[node] != null)
      return isSafe[node]; // memo

    color[node] = 1; // mark as visiting
    for (int nei : graph[node]) {
      if (color[nei] == 1) { // back-edge -> cycle
        isSafe[node] = false;
        color[node] = 2; // mark processed
        return false;
      }
      if (color[nei] == 0) {
        if (!dfs(nei, graph, color)) {
          isSafe[node] = false;
          color[node] = 2;
          return false;
        }
      } else {
        // color[nei] == 2 -> already processed; we can use memo if available
        if (isSafe[nei] != null && !isSafe[nei]) {
          isSafe[node] = false;
          color[node] = 2;
          return false;
        }
      }
    }

    // all neighbors safe
    isSafe[node] = true;
    color[node] = 2; // processed
    return true;
  }

  public List<Integer> eventualSafeNodes(int[][] graph) {
    int V = graph.length;
    isSafe = new Boolean[V];
    int[] color = new int[V]; // 0 = unvisited, 1 = visiting, 2 = processed

    List<Integer> ans = new ArrayList<>();
    for (int node = 0; node < V; node++) {
      if (isSafe[node] == null) {
        dfs(node, graph, color);
      }
      if (isSafe[node] != null && isSafe[node]) {
        ans.add(node);
      }
    }
    return ans;
  }
}