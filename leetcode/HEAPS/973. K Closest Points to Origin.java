import java.util.PriorityQueue;

class Solution {

  long dist(int x, int y) {
    return (long) x * x + (long) y * y;
  }

  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> Long.compare(a.d, b.d));

    for (int[] p : points) {
      pq.offer(new Element(p[0], p[1], dist(p[0], p[1])));
    }

    int[][] result = new int[k][2];
    int index = 0;

    while (k-- > 0) {
      Element e = pq.poll();
      result[index][0] = e.x;
      result[index][1] = e.y;
      index++;
    }

    return result;
  }
}

class Element {
  int x, y;
  long d;

  Element(int x, int y, long d) {
    this.x = x;
    this.y = y;
    this.d = d;
  }
}
