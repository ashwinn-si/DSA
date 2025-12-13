class Solution {
  int R = 9, C = 9;

  private boolean isValid(int row, int col, int digit, int rowChecker[], int colChecker[], int subMatrixChecker[]) {
    int subCount = (row / 3) * (C / 3) + (col / 3);
    int rowMask = 1 << digit;
    int colMask = 1 << digit;
    int subMatrixMask = 1 << digit;
    return (((rowChecker[row] & rowMask) == 0) && ((colChecker[col] & colMask) == 0)
        && ((subMatrixChecker[subCount] & subMatrixMask) == 0));
  }

  private int[] findNextRowCol(int row, int col, char matrix[][]) {
    while (0 <= row && row < R && 0 <= col && col < C) {
      if (matrix[row][col] == '.') {
        return new int[] { row, col };
      }
      col++;
      if (col == C) {
        col = 0;
        row++;
      }
    }
    return new int[] { row, col };
  }

  private boolean dfs(int currR, int currC, char[][] matrix, int rowChecker[], int colChecker[],
      int subMatrixChecker[]) {
    if (currR == R) {
      return true;
    }
    for (int fillDigit = 1; fillDigit < 10; fillDigit++) {
      if (isValid(currR, currC, fillDigit, rowChecker, colChecker, subMatrixChecker)) {
        int subCount = (currR / 3) * (C / 3) + (currC / 3);
        int rowMask = 1 << fillDigit;
        int colMask = 1 << fillDigit;
        int subMatrixMask = 1 << fillDigit;
        rowChecker[currR] |= (rowMask);
        colChecker[currC] |= (colMask);
        subMatrixChecker[subCount] |= (subMatrixMask);
        matrix[currR][currC] = (char) ('0' + fillDigit);
        int next[] = findNextRowCol(currR, currC, matrix);
        if (dfs(next[0], next[1], matrix, rowChecker, colChecker, subMatrixChecker)) {
          return true;
        }
        rowChecker[currR] ^= (rowMask);
        colChecker[currC] ^= (colMask);
        subMatrixChecker[subCount] ^= (subMatrixMask);
        matrix[currR][currC] = '.';
      }
    }
    return false;
  }

  public void solveSudoku(char[][] matrix) {
    // row, col, submatrix
    int rowChecker[] = new int[R];
    int colChecker[] = new int[C];
    int subMatrixChecker[] = new int[9];
    int startR = -1, startC = -1;

    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        if (matrix[row][col] == '.') {
          if (startR == -1) {
            startR = row;
            startC = col;
          }
          continue;
        }

        rowChecker[row] = (rowChecker[row] | (1 << (matrix[row][col] - '0')));
        colChecker[col] = (colChecker[col] | (1 << (matrix[row][col] - '0')));
        int subMatrixCount = (row / 3) * (C / 3) + (col / 3);
        subMatrixChecker[subMatrixCount] = (subMatrixChecker[subMatrixCount] | (1 << (matrix[row][col] - '0')));
      }
    }
    dfs(startR, startC, matrix, rowChecker, colChecker, subMatrixChecker);
  }
}