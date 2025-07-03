class Solution {
  int R;
  int C;
  PriorityQueue<Coor> pq = new PriorityQueue<>();
  int offsets[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
  int visited[][];
  int maxValue = 0;

  boolean isValid(int currR, int currC) {
    return currR >= 0 && currR < R && currC >= 0 && currC < C;
  }

  void populate(Coor currCoor, int matrix[][]) {
    for (int i = 0; i < 4; i++) {
      int newR = currCoor.row + offsets[i][0];
      int newC = currCoor.col + offsets[i][1];
      if (isValid(newR, newC) && visited[newR][newC] == 0) {
        visited[newR][newC]++;
        pq.offer(new Coor(newR, newC, matrix[newR][newC]));
      }
    }
  }

  public int swimInWater(int[][] matrix) {
    R = matrix.length;
    C = matrix[0].length;
    visited = new int[R][C];
    pq.offer(new Coor(0, 0, matrix[0][0]));
    while (true) {
      Coor currCoor = pq.poll();
      maxValue = Math.max(currCoor.val, maxValue);
      if (currCoor.row == R - 1 && currCoor.col == C - 1) {
        return maxValue;
      }
      populate(currCoor, matrix);
    }
  }
}

class Coor implements Comparable<Coor> {
  int row, col, val;

  Coor(int row, int col, int val) {
    this.row = row;
    this.col = col;
    this.val = val;
  }

  @Override
  public int compareTo(Coor other) {
    return this.val - other.val;
  }
}