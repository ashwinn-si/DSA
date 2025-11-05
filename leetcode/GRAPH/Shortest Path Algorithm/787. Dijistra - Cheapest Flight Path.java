class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    List<List<List<Integer>>> adj = new ArrayList<>();
    for (int index = 0; index < n; index++) {
      adj.add(new ArrayList<>());
    }
    for (int flight[] : flights) {
      int u = flight[0];
      int v = flight[1];
      int price = flight[2];
      adj.get(u).add(new ArrayList<>(Arrays.asList(v, price)));
    }
    int result[] = new int[n];
    Arrays.fill(result, Integer.MAX_VALUE);
    result[src] = 0;
    Queue<Element> pq = new LinkedList<>();
    pq.offer(new Element(src, 0, 0));
    while (!pq.isEmpty()) {
      Element currElement = pq.poll();
      int node = currElement.node;
      int stop = currElement.noStops;
      int price = currElement.price;
      if (stop > k) {
        continue;
      }
      for (List<Integer> iter : adj.get(node)) {
        int edjW = iter.get(1);
        int adjNode = iter.get(0);
        if (result[adjNode] == Integer.MAX_VALUE || result[adjNode] > price + edjW) {
          result[adjNode] = price + edjW;
          pq.offer(new Element(adjNode, stop + 1, price + edjW));
        }
      }
    }
    return result[dst] == Integer.MAX_VALUE ? -1 : result[dst];
  }
}

class Element {
  int node, noStops, price;

  Element(int node, int noStops, int price) {
    this.node = node;
    this.noStops = noStops;
    this.price = price;
  }
}