class Solution {
  public int intersectionSizeTwo(int[][] intervals) {
    Arrays.sort(intervals, (x, y) -> {
      if (x[1] != y[1])
        return x[1] - y[1];
      return y[0] - x[0];
    });

    int resultSize = 2;
    int a = intervals[0][1] - 1;
    int b = intervals[0][1];
    for (int index = 1; index < intervals.length; index++) {
      int currStart = intervals[index][0];
      int currEnd = intervals[index][1];
      // if both a and b falls on the interval then we have no issues
      if (a >= currStart && a <= currEnd && b >= currStart && b <= currEnd) {
        continue;
      }
      if (a < currStart) {

        resultSize++;
        a = currEnd;
      }
      if (b < currStart) {
        resultSize++;
        b = a != currEnd ? currEnd : currEnd - 1;
      }
      int maxVal = Math.max(a, b);
      int minVal = Math.min(a, b);
      a = minVal;
      b = maxVal;
    }
    return resultSize;
  }
}