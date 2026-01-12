class Solution {
  public int minTimeToVisitAllPoints(int[][] points) {
    int totalSec = 0;
    int prevPoint[] = points[0];
    for (int index = 1; index < points.length; index++) {
      int currPoint[] = points[index];
      int xStep = Math.abs(currPoint[0] - prevPoint[0]);
      int yStep = Math.abs(currPoint[1] - prevPoint[1]);
      totalSec += Math.max(xStep, yStep);
      prevPoint = currPoint;
    }
    return totalSec;
  }
}