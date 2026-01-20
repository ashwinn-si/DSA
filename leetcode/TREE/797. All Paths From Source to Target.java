class Solution {
  List<List<Integer>> result;

  void dfs(int node, int graph[][], List<Integer> curr, int N) {
    if (node == N - 1) {
      result.add(new ArrayList<>(curr));
      return;
    }
    for (int adj : graph[node]) {
      curr.add(adj);
      dfs(adj, graph, curr, N);
      curr.remove(curr.size() - 1);
    }
  }

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    result = new ArrayList<>();
    dfs(0, graph, new ArrayList<>(Arrays.asList(0)), graph.length);
    return result;
  }
}