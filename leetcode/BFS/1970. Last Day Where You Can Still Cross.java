class Solution {
  int offsets[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
  int R, C;

  boolean isValid(int row, int col) {
    return row >= 0 && row < R && col >= 0 && col < C;
  }

  boolean bfs(int startRow, int startCol, int[][] matrix) {
    Queue<int[]> queue = new LinkedList<>();

    queue.offer(new int[] { startRow, startCol });
    matrix[startRow][startCol] = 1;

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      int row = curr[0];
      int col = curr[1];

      if (row == R - 1) {
        return true;
      }

      for (int[] offset : offsets) {
        int newR = row + offset[0];
        int newC = col + offset[1];

        if (isValid(newR, newC) && matrix[newR][newC] == 0) {
          matrix[newR][newC] = 1;
          queue.offer(new int[] { newR, newC });
        }
      }
    }

    return false;
  }

  boolean fillMatrix(int cells[][], int checkDay) {
    int matrix[][] = new int[R][C];
    for (int index = 0; index <= checkDay; index++) {
      int cell[] = cells[index];
      matrix[cell[0] - 1][cell[1] - 1] = 1;
    }
    boolean isPossible = false;
    for (int col = 0; col < C; col++) {
      if (matrix[0][col] == 0) {
        matrix[0][col] = 1;
        isPossible |= bfs(0, col, matrix);
        matrix[0][col] = 0;
        if (isPossible) {
          break;
        }
      }
    }
    return isPossible;
  }

  public int latestDayToCross(int r, int c, int[][] cells) {
    R = r;
    C = c;
    int matrix[][] = new int[R][C];
    int start = 0, end = cells.length - 1;
    int answer = 0;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (fillMatrix(cells, mid)) {
        answer = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return answer + 1;
  }
}