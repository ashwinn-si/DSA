class Solution {
  private final int MOD = 1_000_000_007;

  public int countPaths(int n, int[][] roads) {
    List<int[]>[] graph = new ArrayList[n];
    for (int index = 0; index < n; index++) {
      graph[index] = new ArrayList<>();
    }
    for (int road[] : roads) {
      graph[road[0]].add(new int[] { road[1], road[2] });
      graph[road[1]].add(new int[] { road[0], road[2] });
    }
    long dist[] = new long[n];
    Arrays.fill(dist, Long.MAX_VALUE);
    long count[] = new long[n];
    Queue<Element> pq = new PriorityQueue<>(Comparator.comparingLong(e -> e.time));
    dist[0] = 0L;
    count[0] = 1L;
    pq.offer(new Element(0, 0L));

    while (!pq.isEmpty()) {
      Element currElement = pq.poll();
      int node = currElement.node;
      long time = currElement.time;

      if (dist[node] < time) {
        continue;
      }
      for (int[] iter : graph[node]) {
        int adjNode = iter[0];
        int edjW = iter[1];
        long totalW = edjW + time;

        if (dist[adjNode] > totalW) {
          dist[adjNode] = totalW;
          count[adjNode] = count[node];
          count[adjNode] %= MOD;
          pq.offer(new Element(adjNode, totalW));
        } else if (dist[adjNode] == totalW) {
          count[adjNode] += count[node];
          count[adjNode] %= MOD;
        }
      }
    }

    return (int) (count[n - 1] % MOD);
  }
}

class Element {
  int node;
  long time;

  Element(int node, long time) {
    this.node = node;
    this.time = time;
  }
}