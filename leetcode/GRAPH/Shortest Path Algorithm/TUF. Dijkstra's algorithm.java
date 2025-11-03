class Solution {
  public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
    int result[] = new int[V];
    Arrays.fill(result, 1000000000);

    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
    pq.offer(new Node(S, 0));
    result[S] = 0;

    while (!pq.isEmpty()) {
      Node currNode = pq.poll();
      if (currNode.cost > result[currNode.node])
        continue;
      for (ArrayList<Integer> adjNode : adj.get(currNode.node)) {
        if (result[adjNode.get(0)] == 1000000000
            || result[adjNode.get(0)] > currNode.cost + adjNode.get(1)) {
          result[adjNode.get(0)] = currNode.cost + adjNode.get(1);
          pq.offer(new Node(adjNode.get(0), result[adjNode.get(0)]));
        }
      }
    }
    return result;
  }
}

class Node {
  int node, cost;

  Node(int node, int cost) {
    this.node = node;
    this.cost = cost;
  }
}
