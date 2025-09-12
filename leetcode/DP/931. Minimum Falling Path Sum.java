class Solution {
  public int minFallingPathSum(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    int offsets[][] = new int[][] { { -1, 1 }, { -1, -1 }, { -1, 0 } };

    for (int i = 1; i < R; i++) {
      for (int j = 0; j < C; j++) {
        int result = Integer.MAX_VALUE;
        for (int index = 0; index < 3; index++) {
          int upR = i + offsets[index][0];
          int upC = j + offsets[index][1];
          if (upR >= 0 && upR < R && upC >= 0 && upC < C) {
            result = Math.min(result, matrix[i][j] + matrix[upR][upC]);
          }
        }
        matrix[i][j] = result;
      }
    }

    int result = Integer.MAX_VALUE;
    for (int j = 0; j < C; j++) {
      result = Math.min(result, matrix[R - 1][j]);
    }
    return result;
  }
}