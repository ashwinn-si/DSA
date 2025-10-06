class Solution {
  static int offsets[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
  static int R, C;

  static boolean isValid(int currR, int currC) {
    return currR >= 0 && currR < R && currC >= 0 && currC < C;
  }

  public int swimInWater(int[][] matrix) {
    R = matrix.length;
    C = matrix[0].length;

    PriorityQueue<Coor> pq = new PriorityQueue<>((a, b) -> a.minHeight - b.minHeight);
    pq.offer(new Coor(0, 0, matrix[0][0]));
    matrix[0][0] = Integer.MAX_VALUE;

    while (!pq.isEmpty()) {
      Coor currCoor = pq.poll();
      if (currCoor.row == R - 1 && currCoor.col == C - 1) {
        return currCoor.minHeight;
      }
      for (int index = 0; index < 4; index++) {
        int newR = currCoor.row + offsets[index][0];
        int newC = currCoor.col + offsets[index][1];
        if (isValid(newR, newC) && matrix[newR][newC] != Integer.MAX_VALUE) {
          pq.offer(new Coor(newR, newC, Math.max(matrix[newR][newC], currCoor.minHeight)));
          matrix[newR][newC] = Integer.MAX_VALUE;
        }
      }
    }

    return -1;
  }
}

class Coor {
  int minHeight;
  int row, col;

  Coor(int row, int col, int minHeight) {
    this.row = row;
    this.col = col;
    this.minHeight = minHeight;
  }
}