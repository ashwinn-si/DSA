class Solution {
  public int[][] merge(int[][] intervals) {
    List<List<Integer>> result = new ArrayList<>();
    int N = intervals.length;
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    int start = -1, end = -1;
    for (int i = 0; i < N; i++) {
      int currIndexStartValue = intervals[i][0];
      int currIndexEndValue = intervals[i][1];
      if (start == -1 && end == -1) {
        start = currIndexStartValue;
        end = currIndexEndValue;
      } else {
        if (currIndexStartValue >= start && currIndexStartValue <= end) {
          end = Math.max(end, currIndexEndValue);
        } else {
          result.add(Arrays.asList(start, end));
          start = currIndexStartValue;
          end = currIndexEndValue;
        }
      }
    }
    result.add(Arrays.asList(start, end));
    int returnResult[][] = new int[result.size()][2];
    for (int i = 0; i < result.size(); i++) {
      returnResult[i][0] = result.get(i).get(0);
      returnResult[i][1] = result.get(i).get(1);
    }
    return returnResult;
  }
}