class Solution {
  public int maxMeetings(int[] start, int[] end) {
    // your code goes here
    int N = start.length;
    // start, end, duration
    List<int[]> meetings = new ArrayList<>();
    for (int index = 0; index < N; index++) {
      meetings.add(new int[] { start[index], end[index], end[index] - start[index] });
    }
    Collections.sort(meetings, (a, b) -> {
      return Integer.compare(a[1], b[1]);
    });

    int endTime = -1;
    int count = 0;
    for (int meet[] : meetings) {
      if (endTime < meet[0]) {
        endTime = meet[1];
        count++;
      }
    }
    return count;
  }
}