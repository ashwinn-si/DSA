class Solution {
  // 0 -> not colored
  // 1 -> y | 2 -> r
  boolean dfs(int currNode, int[][] graph, int colorNode[], int adjColor) {
    boolean result = true;
    for (int adjNode : graph[currNode]) {
      if (colorNode[adjNode] == 0) {
        colorNode[adjNode] = adjColor;
        result = result && dfs(adjNode, graph, colorNode, adjColor == 1 ? 2 : 1);
      } else if (colorNode[adjNode] == colorNode[currNode]) {
        return false;
      }
    }
    return result;
  }

  public boolean isBipartite(int[][] graph) {
    int colorNode[] = new int[graph.length];
    for (int index = 0; index < graph.length; index++) {
      if (colorNode[index] == 0) {
        colorNode[index] = 1;
        if (!dfs(index, graph, colorNode, 2)) {
          return false;
        }
      }
    }
    return true;
  }
}