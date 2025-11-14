//2D Difference Array Technique
/*
 * declare a 2d array of n + 1, n + 1
 * In query:
 * r1, c1 -> ++
 * r2 + 1, c2 + 1 -> ++
 * r1, c2 + 1 -> --
 * r2 + 1, c1 -> --
 * 
 * building
 * i, j -> (i, j) + (i - 1, j) + (i, j - 1) - (i -1,j - 1)
 * 
 */
class Solution {
  public int[][] rangeAddQueries(int n, int[][] queries) {
    int diff[][] = new int[n + 1][n + 1];
    for (int[] q : queries) {
      int r1 = q[0], r2 = q[2], c1 = q[1], c2 = q[3];
      diff[r1][c1]++;
      diff[r1][c2 + 1]--;
      diff[r2 + 1][c1]--;
      diff[r2 + 1][c2 + 1]++;
    }
    int matrix[][] = new int[n][n];
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        matrix[row][col] = diff[row][col];
        if (row > 0)
          matrix[row][col] += matrix[row - 1][col];
        if (col > 0)
          matrix[row][col] += matrix[row][col - 1];
        if (row > 0 && col > 0)
          matrix[row][col] -= matrix[row - 1][col - 1];
      }
    }
    return matrix;
  }
}
