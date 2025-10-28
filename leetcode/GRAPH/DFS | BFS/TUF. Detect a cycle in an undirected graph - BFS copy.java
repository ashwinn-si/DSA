class Solution {
  boolean bfs(int index, boolean visited[], List<Integer>[] adj) {
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(index, -1));
    while (!queue.isEmpty()) {
      Pair curr = queue.poll();
      if (visited[curr.currNode]) {
        return true;
      }
      visited[curr.currNode] = true;
      for (int nextNode : adj[curr.currNode]) {
        if (nextNode == curr.parentNode) {
          continue;
        }
        queue.offer(new Pair(nextNode, curr.currNode));
      }
    }
    return false;
  }

  public boolean isCycle(int V, List<Integer>[] adj) {
    boolean visited[] = new boolean[V];
    boolean result = true;
    for (int index = 0; index < V; index++) {
      if (adj[index].size() > 0 && !visited[index]) {
        if (bfs(index, visited, adj)) {
          return true;
        }
      }
    }
    return false;
  }
}

class Pair {
  int currNode;
  int parentNode;

  Pair(int currNode, int parentNode) {
    this.currNode = currNode;
    this.parentNode = parentNode;
  }
}