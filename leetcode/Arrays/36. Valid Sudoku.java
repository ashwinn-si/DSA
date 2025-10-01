class Solution {
  private boolean subMatrixChecker(char num, char[][] board, int row, int col) {
    int freq = 0;
    for (int i = row; i < row + 3; i++) {
      for (int j = col; j < col + 3; j++) {
        if (board[i][j] == num)
          freq++;
        if (freq == 2)
          return false;
      }
    }
    return true;
  }

  private boolean colChecker(char num, char[][] board, int col) {
    int freq = 0;
    for (int i = 0; i < 9; i++) {
      if (board[i][col] == num)
        freq++;
      if (freq == 2)
        return false;
    }
    return true;
  }

  private boolean rowChecker(char num, char[][] board, int row) {
    int freq = 0;
    for (int j = 0; j < 9; j++) {
      if (board[row][j] == num)
        freq++;
      if (freq == 2)
        return false;
    }
    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          if (!rowChecker(board[i][j], board, i) || !colChecker(board[i][j], board, j)
              || !subMatrixChecker(board[i][j], board, 3 * (i / 3), 3 * (j / 3))) {
            return false;
          }
        }
      }
    }
    return true;
  }
}