class Solution {
  public int minPathSum(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;

    for (int i = 1; i < R; i++)
      matrix[i][0] += matrix[i - 1][0];
    for (int j = 1; j < C; j++)
      matrix[0][j] += matrix[0][j - 1];

    for (int i = 1; i < R; i++) {
      for (int j = 1; j < C; j++) {
        matrix[i][j] = Math.min(matrix[i - 1][j] + matrix[i][j], matrix[i][j - 1] + matrix[i][j]);
      }
    }
    return matrix[R - 1][C - 1];
  }
}