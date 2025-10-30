class Solution {
  int R, C;
  int offsets[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

  boolean isValid(int currR, int currC) {
    return currR >= 0 && currR < R && currC >= 0 && currC < C;
  }

  void dfs(int currR, int currC, char matrix[][]) {
    matrix[currR][currC] = 0;
    for (int index = 0; index < 8; index++) {
      int newR = currR + offsets[index][0];
      int newC = currC + offsets[index][1];
      if (isValid(newR, newC) && matrix[newR][newC] == '1') {
        dfs(newR, newC, matrix);
      }
    }
  }

  public int numIslands(char[][] matrix) {
    R = matrix.length;
    C = matrix[0].length;
    int count = 0;
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (matrix[row][col] == '1') {
          count++;
          dfs(row, col, matrix);
        }
      }
    }
    return count;
  }
}
