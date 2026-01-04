class Solution {
  private int offsets[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
  int R, C;

  boolean isValid(int row, int col) {
    return row >= 0 && row < R && col >= 0 && col < C;
  }

  int[] getCount(int row, int col, int matrix[][]) {
    int liveCount = 0, dieCount = 0;
    for (int offset[] : offsets) {
      int newR = offset[0] + row;
      int newC = offset[1] + col;
      if (isValid(newR, newC)) {
        if (matrix[newR][newC] == 0) {
          dieCount++;
        } else {
          liveCount++;
        }
      }
    }
    return new int[] { liveCount, dieCount };
  }

  boolean canLive(int row, int col, int matrix[][]) {
    int count[] = getCount(row, col, matrix);
    if (matrix[row][col] == 1 && (count[0] == 2 || count[0] == 3)) {
      return true;
    }
    if (matrix[row][col] == 0 && count[0] == 3) {
      return true;
    }
    return false;
  }

  public void gameOfLife(int[][] matrix) {
    R = matrix.length;
    C = matrix[0].length;
    int newMatrix[][] = new int[R][C];
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        newMatrix[row][col] = canLive(row, col, matrix) ? 1 : 0;
      }
    }
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        matrix[row][col] = newMatrix[row][col];
      }
    }
    return;
  }
}