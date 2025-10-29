class Solution {
  int R, C;
  boolean result[][];
  int offsets[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  boolean isValid(int currR, int currC) {
    return currR >= 0 && currR < R && currC >= 0 && currC < C;
  }

  boolean isBoundary(int currR, int currC) {
    return currR == 0 || currC == 0 || currR == R - 1 || currC == C - 1;
  }

  void dfs(int currR, int currC, char matrix[][]) {
    result[currR][currC] = true;
    for (int index = 0; index < 4; index++) {
      int newR = currR + offsets[index][0];
      int newC = currC + offsets[index][1];
      if (isValid(newR, newC) && !result[newR][newC] && matrix[newR][newC] == 'O') {
        dfs(newR, newC, matrix);
      }
    }
  }

  public void solve(char[][] matrix) {
    R = matrix.length;
    C = matrix[0].length;
    result = new boolean[R][C];
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (matrix[row][col] == 'O' && isBoundary(row, col) && !result[row][col]) {
          dfs(row, col, matrix);
        }
      }
    }

    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (!result[row][col]) {
          matrix[row][col] = 'X';
        }
      }
    }
  }
}