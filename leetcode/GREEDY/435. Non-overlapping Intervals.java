class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
    int result = 0;
    int curr[] = intervals[0];
    for (int index = 1; index < intervals.length; index++) {
      int interval[] = intervals[index];
      if (curr[1] > interval[0]) {
        result++;
      } else {
        curr = interval;
      }
    }
    return result;
  }
}