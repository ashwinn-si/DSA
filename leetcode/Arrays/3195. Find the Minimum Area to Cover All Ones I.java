class Solution {
  public int minimumArea(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    int stC = -1, endC = -1;
    int stR = -1, endR = -1;
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (matrix[i][j] == 1) {
          if (stC == -1) {
            stR = i + 1;
            stC = j + 1;
            endR = i + 1;
            endC = j + 1;
          } else {
            stR = Math.min(i + 1, stR);
            stC = Math.min(j + 1, stC);
            endR = Math.max(i + 1, endR);
            endC = Math.max(j + 1, endC);
          }
        }
      }
    }
    System.out.println(stR + " " + endR);
    System.out.println(stC + " " + endC);
    return (int) ((endR - stR + 1) * (endC - stC + 1));
  }
}