class Solution {
  // Function to return Breadth First Search Traversal of given graph.
  public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
    int N = adj.size();
    ArrayList<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[N];
    Queue<Integer> pq = new LinkedList<>();

    pq.offer(0);
    visited[0] = true;

    while (!pq.isEmpty()) {
      int element = pq.poll();
      result.add(element);

      for (int num : adj.get(element)) {
        if (!visited[num]) {
          pq.offer(num);
          visited[num] = true;
        }
      }
    }
    return result;
  }
}
