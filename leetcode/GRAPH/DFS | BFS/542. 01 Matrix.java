class Solution {
  public int[][] updateMatrix(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    int[][] result = new int[R][C];
    Queue<int[]> queue = new LinkedList<>();
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (matrix[row][col] == 0) {
          queue.offer(new int[] { row, col });
          result[row][col] = 0;
        } else {
          result[row][col] = Integer.MAX_VALUE;
        }
      }
    }

    int offsets[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    while (!queue.isEmpty()) {
      int cell[] = queue.poll();
      int r = cell[0], c = cell[1];
      for (int index = 0; index < 4; index++) {
        int newR = r + offsets[index][0], newC = c + offsets[index][1];
        if (newR >= 0 && newR < R && newC >= 0 && newC < C) {
          if (result[newR][newC] > result[r][c] + 1) {
            result[newR][newC] = result[r][c] + 1;
            queue.offer(new int[] { newR, newC });
          }
        }
      }
    }

    return result;
  }
}