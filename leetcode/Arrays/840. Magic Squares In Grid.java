class Solution {
  boolean isMagicSquare(int matrix[][], int R, int C) {
    int freq[] = new int[10];
    int rowSum[] = new int[3];
    int colSum[] = new int[3];
    int d1Coor[] = { R, C };
    int d2Coor[] = { R, C + 2 };
    int dSum[] = new int[2];
    for (int row = R; row < R + 3; row++) {
      for (int col = C; col < C + 3; col++) {
        int num = matrix[row][col];
        if (matrix[row][col] > 9 || matrix[row][col] <= 0) {
          return false;
        }
        if (freq[num] != 0) {
          return false;
        }
        freq[num]++;
        rowSum[row - R] += num;
        colSum[col - C] += num;
        if (row == d1Coor[0] && col == d1Coor[1]) {
          d1Coor[0]++;
          d1Coor[1]++;
          dSum[0] += num;
        }
        if (row == d2Coor[0] && col == d2Coor[1]) {
          d2Coor[0]++;
          d2Coor[1]--;
          dSum[1] += num;
        }
      }
    }
    int targetSum = rowSum[0];

    for (int index = 0; index < 3; index++) {
      if (rowSum[index] != targetSum || colSum[index] != targetSum) {
        return false;
      }
    }
    for (int index = 0; index < 2; index++) {
      if (dSum[index] != targetSum) {
        return false;
      }
    }
    return true;
  }

  public int numMagicSquaresInside(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    int count = 0;
    for (int row = 0; row <= R - 3; row++) {
      for (int col = 0; col <= C - 3; col++) {
        if (isMagicSquare(matrix, row, col)) {
          count++;
        }
      }
    }
    return count;
  }

}