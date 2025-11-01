class Solution {
  int result[];
  int resPointer;

  void dfs(int node, List<List<Integer>> adj, int visited[]) {
    for (int adjNode : adj.get(node)) {
      if (visited[adjNode] == 0) {
        visited[adjNode] = 1;
        dfs(adjNode, adj, visited);
      }
    }
    resPointer[resPointer--] = node;
  }

  public int[] topoSort(int V, List<List<Integer>> adj) {
    result = new int[V];
    resPointer = V - 1;
    int visited[] = new int[V];
    for (int index = 0; index < V; index++) {
      if (visited[index] == 0) {
        visited[index] = 1;
        dfs(index, adj, visited);
      }
    }
    return result;
  }
}