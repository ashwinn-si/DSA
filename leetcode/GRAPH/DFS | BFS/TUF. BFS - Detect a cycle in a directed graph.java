class Solution {
  public boolean isCyclic(int V, List<List<Integer>> adj) {
    int inDegree[] = new int[V];

    for (int index = 0; index < V; index++) {
      for (int node : adj.get(index)) {
        inDegree[node]++;
      }
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int index = 0; index < V; index++) {
      if (inDegree[index] == 0) {
        queue.offer(index);
      }
    }

    int count = 0;
    while (!queue.isEmpty()) {
      int currNode = queue.poll();
      count++;
      for (int adjNode : adj.get(currNode)) {
        inDegree[adjNode]--;
        if (inDegree[adjNode] == 0) {
          queue.offer(adjNode);
        }
      }
    }
    return count != V;
  }
}
