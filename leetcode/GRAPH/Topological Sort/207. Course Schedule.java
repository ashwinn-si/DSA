class Solution {
  boolean dfs(int node, int[][] adjMatrix, int visited[], int N) {
    boolean result = true;
    for (int index = 0; index < N; index++) {
      if (adjMatrix[node][index] == 0 || visited[index] == 2)
        continue;
      if (visited[index] == 1) {
        return false;
      }

      visited[index] = 1;
      result = result & dfs(index, adjMatrix, visited, N);
      if (!result)
        return false;
    }
    visited[node] = 2;
    return result;
  }

  public boolean canFinish(int N, int[][] pre) {
    int adjMatrix[][] = new int[N][N];
    for (int index = 0; index < pre.length; index++) {
      adjMatrix[pre[index][1]][pre[index][0]] = 1;
    }
    int visited[] = new int[N];
    for (int index = 0; index < N; index++) {
      if (visited[index] == 0) {
        visited[index] = 1;
        if (!dfs(index, adjMatrix, visited, N)) {
          return false;
        }
      }
    }
    return true;
  }
}