class Solution {
  public int networkDelayTime(int[][] times, int n, int k) {
    List<List<List<Integer>>> graph = new ArrayList<>();
    for (int index = 0; index < n; index++) {
      graph.add(new ArrayList<>());
    }
    for (int time[] : times) {
      int src = time[0] - 1;
      int dst = time[1] - 1;
      int wt = time[2];
      graph.get(src).add(new ArrayList<>(Arrays.asList(dst, wt)));
    }

    int result[] = new int[n];
    Arrays.fill(result, Integer.MAX_VALUE);
    result[k - 1] = 0;
    PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
    pq.offer(new Element(k - 1, 0));

    while (!pq.isEmpty()) {
      Element currElement = pq.poll();
      int node = currElement.node;
      int time = currElement.time;
      if (result[node] < time) {
        continue;
      }
      for (List<Integer> iter : graph.get(node)) {
        int adjNode = iter.get(0);
        int edjW = iter.get(1);
        if (result[adjNode] == Integer.MAX_VALUE || result[adjNode] > edjW + time) {
          result[adjNode] = edjW + time;
          pq.offer(new Element(adjNode, edjW + time));
        }
      }
    }

    int minTime = Integer.MIN_VALUE;
    for (int num : result) {
      if (num == Integer.MAX_VALUE) {
        return -1;
      }
      minTime = Math.max(minTime, num);
    }
    return minTime;
  }
}

class Element {
  int node;
  int time;

  Element(int node, int time) {
    this.node = node;
    this.time = time;
  }
}