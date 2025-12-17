class Solution {
  int R, C;
  int targetR, targetC;
  int count;
  int offsets[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  boolean isValid(int row, int col) {
    return row >= 0 && row < R && col >= 0 && col < C;
  }

  void dfs(int row, int col, int matrix[][], int freeCell) {
    if (row == targetR && col == targetC && freeCell == 0) {
      count++;
    }
    for (int index = 0; index < 4; index++) {
      int newR = offsets[index][0] + row;
      int newC = offsets[index][1] + col;
      if (isValid(newR, newC) && matrix[newR][newC] != -1) {
        matrix[newR][newC] = -1;
        dfs(newR, newC, matrix, freeCell - 1);
        matrix[newR][newC] = 1;
      }
    }
  }

  public int uniquePathsIII(int[][] matrix) {
    R = matrix.length;
    C = matrix[0].length;
    count = 0;
    int targetCount = 0;
    int freeCell = 0;
    int startR = 0, startC = 0;
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (matrix[row][col] == -1) {
          continue;
        }
        if (matrix[row][col] == 1) {
          startR = row;
          startC = col;
        } else if (matrix[row][col] == 2) {
          targetR = row;
          targetC = col;
        }
        matrix[row][col] = 0;
        freeCell++;
      }
    }
    matrix[startR][startC] = -1;
    dfs(startR, startC, matrix, freeCell - 1);
    return count;
  }
}