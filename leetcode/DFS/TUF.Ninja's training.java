class Solution {
  public int ninjaTraining(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    int max = 0;
    for (int i = 1; i < R; i++) {
      for (int j = 0; j < C; j++) {
        matrix[i][j] = Math.max(
            matrix[i][j] + matrix[i - 1][(j + 1) % C],
            matrix[i][j] + matrix[i - 1][(j + 2) % C]);
        max = Math.max(max, matrix[i][j]);
      }
    }
    return max;
  }
}