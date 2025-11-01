class Solution {
  public int[] topoSort(int V, List<List<Integer>> adj) {
    int inDegree[] = new int[V];
    for (int index = 0; index < V; index++) {
      for (int node : adj.get(index)) {
        inDegree[node]++;
      }
    }
    int result[] = new int[V];
    int resPointer = 0;
    Queue<Integer> queue = new LinkedList<>();
    for (int index = 0; index < V; index++) {
      if (inDegree[index] == 0) {
        queue.offer(index);
      }
    }
    while (!queue.isEmpty()) {
      int currNode = queue.poll();
      result[resPointer++] = currNode;
      for (int adjNode : adj.get(currNode)) {
        inDegree[adjNode]--;
        if (inDegree[adjNode] == 0) {
          queue.offer(adjNode);
        }
      }
    }
    return result;
  }
}