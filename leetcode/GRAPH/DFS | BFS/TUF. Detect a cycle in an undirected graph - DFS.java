class Solution {
  boolean dfs(int currNode, boolean visited[], List<Integer>[] adj, int parentNode) {
    if (visited[currNode]) {
      return true;
    }
    visited[currNode] = true;
    for (int adjNode : adj[currNode]) {
      if (adjNode == parentNode) {
        continue;
      }
      if (dfs(adjNode, visited, adj, currNode))
        return true;
    }
    return false;
  }

  public boolean isCycle(int V, List<Integer>[] adj) {
    boolean visited[] = new boolean[V];
    for (int index = 0; index < V; index++) {
      if (adj[index].size() > 0 && !visited[index]) {
        if (dfs(index, visited, adj, -1)) {
          return true;
        }
      }
    }
    return false;
  }
}