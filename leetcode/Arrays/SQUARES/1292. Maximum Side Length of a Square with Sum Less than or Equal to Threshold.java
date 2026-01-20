class Solution {
  public int maxSideLength(int[][] mat, int threshold) {
    int R = mat.length;
    int C = mat[0].length;
    int maxPos = Math.min(R, C);
    int prex[][] = new int[R][C + 1];
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        prex[row][col + 1] = prex[row][col] + mat[row][col];
      }
    }
    while (maxPos > 0) {
      for (int row = 0; row <= R - maxPos; row++) {
        for (int col = 0; col <= C - maxPos; col++) {
          int sum = getSum(prex, row, col, maxPos);
          if (sum <= threshold) {
            return maxPos;
          }
        }
      }
      maxPos--;
    }
    return 0;
  }

  int getSum(int prex[][], int R, int C, int size) {
    int sum = 0;
    for (int row = R; row < R + size; row++) {
      sum += prex[row][C + size] - prex[row][C];
    }
    return sum;
  }
}