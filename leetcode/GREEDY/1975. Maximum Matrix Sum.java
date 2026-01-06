class Solution {
  public long maxMatrixSum(int[][] matrix) {
    int noNegatives = 0;
    int leastNegative = Integer.MAX_VALUE;
    long sum = 0L;
    int R = matrix.length, C = matrix[0].length;
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (matrix[row][col] < 0) {
          noNegatives++;
        }
        leastNegative = Math.min(Math.abs(matrix[row][col]), leastNegative);
        sum += Math.abs(matrix[row][col]);
      }
    }
    return noNegatives % 2 == 0 ? sum : sum - (2 * (leastNegative));
  }
}