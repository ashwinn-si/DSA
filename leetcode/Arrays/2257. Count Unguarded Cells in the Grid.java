class Solution {
  boolean isValid(int newR, int newC, int R, int C) {
    return newR >= 0 && newR < R && newC >= 0 && newC < C;
  }

  int simulateDirection(int currR, int currC, int offR, int offC, int result, int matrix[][], int R, int C) {
    while (isValid(currR, currC, R, C)) {
      if (matrix[currR][currC] == 3 || matrix[currR][currC] == 2) {
        break;
      }

      if (matrix[currR][currC] == 0) {
        result--;
        matrix[currR][currC] = 1;
      }
      currR += offR;
      currC += offC;
    }
    return result;
  }

  public int countUnguarded(int R, int C, int[][] guards, int[][] walls) {
    // 0 -> unoccupied
    // 1 -> occupied (guarded)
    // 2 -> guard
    // 3 -> wall
    int result = R * C;
    int matrix[][] = new int[R][C];
    for (int coor[] : walls) {
      matrix[coor[0]][coor[1]] = 3;
      result--;
    }

    for (int coor[] : guards) {
      int currR = coor[0];
      int currC = coor[1];
      if (matrix[currR][currC] == 0) {
        result--;
      }
      matrix[currR][currC] = 2;
    }

    for (int[] coor : guards) {
      int currR = coor[0], currC = coor[1];
      result = simulateDirection(currR + 1, currC, 1, 0, result, matrix, R, C);
      result = simulateDirection(currR, currC + 1, 0, 1, result, matrix, R, C);
      result = simulateDirection(currR - 1, currC, -1, 0, result, matrix, R, C);
      result = simulateDirection(currR, currC - 1, 0, -1, result, matrix, R, C);
    }

    return result;
  }
}
