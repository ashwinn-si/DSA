class Solution {
  void dfs(boolean visited[], int index, int adjMatrix[][]) {
    for (int col = 0; col < adjMatrix.length; col++) {
      if (adjMatrix[index][col] > 0 && !visited[col]) {
        visited[col] = true;
        dfs(visited, col, adjMatrix);
      }
    }
  }

  public int findNumberOfComponent(int V, List<List<Integer>> edges) {
    int adjMatrix[][] = new int[V][V];
    for (List<Integer> curr : edges) {
      adjMatrix[curr.get(0)][curr.get(1)]++;
      adjMatrix[curr.get(1)][curr.get(0)]++;
    }

    int result = 0;
    boolean visited[] = new boolean[V];
    for (int index = 0; index < V; index++) {
      if (!visited[index]) {
        result++;
        dfs(visited, index, adjMatrix);
      }
    }
    return result;
  }
}
