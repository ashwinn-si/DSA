class Solution {
  public int[] shortestPath(int N, int M, int[][] edges) {
    List<List<Element>> adj = new ArrayList<>();
    for (int index = 0; index < N; index++) {
      adj.add(new ArrayList<>());
    }
    for (int index = 0; index < M; index++) {
      adj.get(edges[index][0]).add(new Element(edges[index][1], edges[index][2]));
    }

    int result[] = new int[N];
    Arrays.fill(result, -1);
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { 0, 0 });
    result[0] = 0;
    while (!queue.isEmpty()) {
      int currNode[] = queue.poll();
      for (Element adjNode : adj.get(currNode[0])) {
        if (result[adjNode.node] == -1) {
          result[adjNode.node] = currNode[1] + adjNode.weight;
        } else {
          result[adjNode.node] = Math.min(result[adjNode.node], currNode[1] + adjNode.weight);
        }
        if (result[adjNode.node] == currNode[1] + adjNode.weight) {
          queue.offer(new int[] { adjNode.node, currNode[1] + adjNode.weight });
        }

      }
    }
    return result;
  }
}

class Element {
  int node, weight;

  Element(int node, int weight) {
    this.node = node;
    this.weight = weight;
  }
}