class Solution {
  public List<Integer> eventualSafeNodes(int[][] graph) {
    List<List<Integer>> reverseGraph = new ArrayList<>();
    int V = graph.length;
    int inDegree[] = new int[V];
    for (int index = 0; index < V; index++) {
      reverseGraph.add(new ArrayList<Integer>());
    }
    for (int node = 0; node < V; node++) {
      for (int adjNode : graph[node]) {
        reverseGraph.get(adjNode).add(node);
        inDegree[node]++;
      }
    }
    TreeSet<Integer> set = new TreeSet<>();
    Queue<Integer> queue = new LinkedList<>();
    for (int node = 0; node < V; node++) {
      if (inDegree[node] == 0) {
        queue.add(node);
      }
    }

    while (!queue.isEmpty()) {
      int node = queue.poll();
      set.add(node);
      for (int adjNode : reverseGraph.get(node)) {
        inDegree[adjNode]--;
        if (inDegree[adjNode] == 0) {
          queue.offer(adjNode);
        }
      }
    }

    return new ArrayList<>(set);
  }
}