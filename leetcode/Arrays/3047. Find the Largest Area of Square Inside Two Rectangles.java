class Solution {
  public long largestSquareArea(int[][] bl, int[][] tr) {
    long result = 0L;
    int n = bl.length;
    for (int index1 = 0; index1 < n; index1++) {
      for (int index2 = index1 + 1; index2 < n; index2++) {
        int minX = Math.max(bl[index1][0], bl[index2][0]);
        int maxX = Math.min(tr[index1][0], tr[index2][0]);
        int minY = Math.max(bl[index1][1], bl[index2][1]);
        int maxY = Math.min(tr[index1][1], tr[index2][1]);

        if (minX < maxX && minY < maxY) {
          int len = Math.min(maxX - minX, maxY - minY);
          result = Math.max(result, len);
        }
      }
    }
    return result * result;
  }
}