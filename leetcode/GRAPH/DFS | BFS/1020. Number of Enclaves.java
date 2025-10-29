class Solution {
  int R, C;
  int offsets[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  boolean isValid(int currR, int currC) {
    return currR >= 0 && currR < R && currC >= 0 && currC < C;
  }

  boolean isBoundary(int currR, int currC) {
    return currR == 0 || currC == 0 || currR == R - 1 || currC == C - 1;
  }

  void dfs(int currR, int currC, int matrix[][]) {
    matrix[currR][currC] = 0;
    for (int index = 0; index < 4; index++) {
      int newR = currR + offsets[index][0];
      int newC = currC + offsets[index][1];
      if (isValid(newR, newC) && matrix[newR][newC] == 1) {
        dfs(newR, newC, matrix);
      }
    }
  }

  public int numEnclaves(int[][] matrix) {
    R = matrix.length;
    C = matrix[0].length;

    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (isBoundary(row, col) && matrix[row][col] == 1) {
          dfs(row, col, matrix);
        }
      }
    }

    int count = 0;
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (matrix[row][col] == 1) {
          count++;
        }
      }
    }

    return count;
  }
}