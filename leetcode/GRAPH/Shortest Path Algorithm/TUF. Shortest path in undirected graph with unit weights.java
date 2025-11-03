class Solution {
  public int[] shortestPath(int[][] edges, int N, int M) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++)
      adj.add(new ArrayList<>());
    for (int i = 0; i < M; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      adj.get(u).add(v);
      adj.get(v).add(u); // because graph is undirected
    }
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { 0, 0 });
    int result[] = new int[N];
    Arrays.fill(result, -1);
    result[0] = 0;
    // 0 -> edges | 1 -> count
    while (!queue.isEmpty()) {
      int currEdge[] = queue.poll();
      for (int adjEdge : adj.get(currEdge[0])) {
        if (result[adjEdge] == -1) {
          result[adjEdge] = currEdge[1] + 1;
          queue.add(new int[] { adjEdge, currEdge[1] + 1 });
        }
      }
    }
    return result;
  }
}
