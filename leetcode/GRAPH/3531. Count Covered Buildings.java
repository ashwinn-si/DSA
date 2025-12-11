class Solution {
  public int countCoveredBuildings(int n, int[][] buildings) {
    // 0 -> min, 1 -> max
    HashMap<Integer, int[]> xAxisHash = new HashMap<>();
    HashMap<Integer, int[]> yAxisHash = new HashMap<>();
    for (int building[] : buildings) {
      int x = building[0];
      int y = building[1];
      xAxisHash.computeIfAbsent(x, k -> new int[] { Integer.MAX_VALUE, -1 });
      yAxisHash.computeIfAbsent(y, k -> new int[] { Integer.MAX_VALUE, -1 });
      int xAxis[] = xAxisHash.get(x);
      int yAxis[] = yAxisHash.get(y);
      xAxis[0] = Math.min(xAxis[0], y);
      xAxis[1] = Math.max(xAxis[1], y);
      yAxis[0] = Math.min(yAxis[0], x);
      yAxis[1] = Math.max(yAxis[1], x);
    }
    int count = 0;
    for (int building[] : buildings) {
      int x = building[0];
      int y = building[1];

      int xAxis[] = xAxisHash.get(x);
      int yAxis[] = yAxisHash.get(y);

      if (xAxis[0] < y && y < xAxis[1] && yAxis[0] < x && x < yAxis[1]) {
        count++;
      }
    }
    return count;
  }
}