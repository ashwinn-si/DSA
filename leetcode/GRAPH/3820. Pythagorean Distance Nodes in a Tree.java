class Solution {
  boolean canBeTriplet(int nums[]) {
    Arrays.sort(nums);
    return (nums[0] * nums[0]) + (nums[1] * nums[1]) == (nums[2] * nums[2]);
  }

  int[] bfs(int start, List<Integer>[] graph) {
    int[] dist = new int[graph.length];
    Arrays.fill(dist, -1);

    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    dist[start] = 0;

    while (!q.isEmpty()) {
      int node = q.poll();
      for (int adj : graph[node]) {
        if (dist[adj] == -1) {
          dist[adj] = dist[node] + 1;
          q.add(adj);
        }
      }
    }
    return dist;
  }

  public int specialNodes(int n, int[][] edges, int x, int y, int z) {
    List<Integer>[] graph = new List[n];
    for (int i = 0; i < n; i++)
      graph[i] = new ArrayList<>();

    for (int[] e : edges) {
      graph[e[0]].add(e[1]);
      graph[e[1]].add(e[0]);
    }

    int[] dx = bfs(x, graph);
    int[] dy = bfs(y, graph);
    int[] dz = bfs(z, graph);

    int count = 0;

    for (int i = 0; i < n; i++) {
      if (dx[i] == -1 || dy[i] == -1 || dz[i] == -1)
        continue;

      int[] curr = { dx[i], dy[i], dz[i] };
      if (canBeTriplet(curr))
        count++;
    }

    return count;
  }

}