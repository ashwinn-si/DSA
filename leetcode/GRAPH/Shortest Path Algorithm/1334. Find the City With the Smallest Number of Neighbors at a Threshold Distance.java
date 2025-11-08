class Solution {
  int dijistra(int n, List<int[]>[] graph, int source, int maxDistance) {
    int distance[] = new int[n];
    Arrays.fill(distance, Integer.MAX_VALUE);
    int resCount = 0;
    Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    distance[source] = 0;
    pq.offer(new int[] { source, 0 });
    while (!pq.isEmpty()) {
      int currElement[] = pq.poll();
      int node = currElement[0];
      int w = currElement[1];
      if (distance[node] < w) {
        continue;
      }
      for (int iter[] : graph[node]) {
        int adjNode = iter[0];
        int edjW = iter[1];
        if (edjW + w > maxDistance) {
          continue;
        }
        if (distance[adjNode] == Integer.MAX_VALUE || distance[adjNode] > edjW + w) {
          if (distance[adjNode] == Integer.MAX_VALUE) {
            resCount++;
          }
          distance[adjNode] = edjW + w;
          pq.offer(new int[] { adjNode, edjW + w });
        }
      }
    }
    return resCount;
  }

  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    List<int[]>[] graph = new ArrayList[n];
    for (int index = 0; index < n; index++) {
      graph[index] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      int w = edge[2];
      graph[u].add(new int[] { v, w });
      graph[v].add(new int[] { u, w });
    }

    int minCity = Integer.MIN_VALUE;
    int minCount = Integer.MAX_VALUE;
    for (int node = 0; node < n; node++) {
      int currCount = dijistra(n, graph, node, distanceThreshold);
      if (minCount >= currCount) {
        if (minCount == currCount) {
          minCity = Math.max(minCity, node);
        } else {
          minCity = node;
        }
        minCount = currCount;
      }
    }
    return minCity;
  }
}