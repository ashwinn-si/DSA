class Solution {
  public int maxEvents(int[][] events) {
    Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    int n = events.length;
    int totalDays = 0;
    for (int e[] : events) {
      totalDays = Math.max(totalDays, e[1]);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int currIndex = 0;
    int result = 0;
    for (int day = 1; day <= totalDays; day++) {
      while (currIndex < n && events[currIndex][0] <= day) {
        pq.offer(events[currIndex++][1]);
      }
      while (!pq.isEmpty() && pq.peek() < day) {
        pq.poll();
      }
      if (!pq.isEmpty()) {
        result++;
        pq.poll();
      }
    }
    return result;
  }
}