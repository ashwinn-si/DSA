class Solution {
  private final int MOD = 100000;

  public int minimumMultiplications(int[] nums, int start, int end) {
    Queue<Element> pq = new LinkedList<>();
    int visited[] = new int[MOD];
    Arrays.fill(visited, Integer.MAX_VALUE);
    visited[start] = 0;
    pq.offer(new Element(start, 0));
    while (!pq.isEmpty()) {
      Element currElement = pq.poll();
      int num = currElement.num;
      int steps = currElement.steps;
      if (visited[num] < steps) {
        continue;
      }
      if (num == end) {
        return steps;
      }

      for (int adj : nums) {
        int newNum = (adj * num) % MOD;
        if (visited[newNum] > steps + 1) {
          visited[newNum] = steps + 1;
          pq.offer(new Element(newNum, steps + 1));
        }
      }
    }
    return -1;
  }
}

class Element {
  int num;
  int steps;

  Element(int num, int steps) {
    this.num = num;
    this.steps = steps;
  }
}
