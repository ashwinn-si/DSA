class Solution {
  public int[] findOrder(int V, int[][] pre) {
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    for (int index = 0; index < V; index++) {
      adj.put(index, new ArrayList<>());
    }
    int[] inDegree = new int[V];
    for (int course[] : pre) {
      int v1 = course[0];
      int v2 = course[1];
      inDegree[v1]++;
      adj.get(v2).add(v1);
    }
    int result[] = new int[V];
    int pointer = 0;
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
      result[pointer++] = currNode;
      for (int node : adj.get(currNode)) {
        inDegree[node]--;
        if (inDegree[node] == 0) {
          queue.offer(node);
        }
      }
    }
    return count == V ? result : new int[] {};
  }
}