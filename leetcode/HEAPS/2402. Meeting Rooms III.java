class Solution {
  public int mostBooked(int n, int[][] meetings) {
    Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
    // let us maintain a PQ that contains all the free rooms
    PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
    // maintains a pq for curr occupied roosm
    // roomId, endTime
    PriorityQueue<long[]> occ = new PriorityQueue<>(
        (a, b) -> a[1] == b[1] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
    long freq[] = new long[n];
    for (int index = 0; index < n; index++) {
      freeRooms.offer(index);
    }
    for (int meeting[] : meetings) {
      // initial we are emptying all the room till the meeting time
      while (!occ.isEmpty() && occ.peek()[1] <= meeting[0]) {
        freeRooms.offer((int) (occ.poll()[0]));
      }
      // we should assign a free room to the meeting
      if (!freeRooms.isEmpty()) {
        int avaRoom = freeRooms.poll();
        freq[avaRoom]++;
        occ.offer(new long[] { avaRoom, meeting[1] });
      } else {
        // Take the room that frees earliest
        long[] room = occ.poll();
        int roomId = (int) room[0];
        long endTime = room[1];
        freq[roomId]++;
        long duration = meeting[1] - meeting[0];
        occ.offer(new long[] { roomId, endTime + duration });
      }

    }
    long maxFreq = freq[0];
    int ans = 0;
    for (int index = 0; index < n; index++) {
      if (freq[index] > maxFreq) {
        ans = index;
        maxFreq = freq[index];
      }
    }
    return ans;
  }
}