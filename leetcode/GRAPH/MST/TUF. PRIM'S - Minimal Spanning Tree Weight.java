class Solution {
  public int spanningTree(int V, List<List<List<Integer>>> adj) {
    PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
    boolean visited[] = new boolean[V];
    int result = 0;
    pq.offer(new Element(0, 0, -1));
    while (!pq.isEmpty()) {
      Element currElement = pq.poll();
      int currNode = currElement.node;
      int parentNode = currElement.parent;
      if (visited[currNode]) {
        continue;
      }
      result += currElement.weight;
      visited[currElement] = true;
      for (List<Integer> iter : adj.get(currNode)) {
        int adjNode = iter.get(0);
        int edjW = iter.get(1);
        if (adjNode != parentNode && !visited[adjNode]) {
          pq.offer(new Element(adjNode, edjW, currNode));
        }
      }
    }

    return result + 1;
  }
}

class Element {
  int node, parent, weight;

  Element(int node, int weight, int parent) {
    this.node = node;
    this.weight = weight;
    this.parent = parent;
  }
}
