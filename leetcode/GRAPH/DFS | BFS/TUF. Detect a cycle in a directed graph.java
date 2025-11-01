class Solution {
  boolean dfs(int node, int visited[], List<List<Integer>> adj) {
    boolean result = true;
    for (int adjNode : adj.get(node)) {
      if (visited[adjNode] == 1) {
        return false;
      }
      visited[adjNode] = 1;
      result = result && dfs(adjNode, visited, adj);
    }
    visited[node] = 2;
    return result;
  }

  public boolean isCyclic(int N, List<List<Integer>> adj) {
    int visited[] = new int[N];
    for (int node = 0; node < N; node++) {
      if (visited[node] == 0) {
        visited[node] = 1;
        if (!dfs(node, visited, adj)) {
          return true;
        }
      }
    }
    return false;
  }
}
