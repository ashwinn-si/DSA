class Solution {
  int R, C;
  int[][] offsets = {
      { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 },
      { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }
  };

  boolean isValid(int r, int c) {
    return r >= 0 && r < R && c >= 0 && c < C;
  }

  public int shortestPathBinaryMatrix(int[][] matrix) {
    R = matrix.length;
    C = matrix[0].length;

    Queue<Coor> pq = new LinkedList<>();

    if (matrix[0][0] != 0)
      return -1;
    pq.offer(new Coor(0, 0, 1));

    while (!pq.isEmpty()) {
      Coor currCoor = pq.poll();
      if (currCoor.r == R - 1 && currCoor.c == C - 1)
        return currCoor.step;
      for (int i = 0; i < 8; i++) {
        int newR = currCoor.r + offsets[i][0];
        int newC = currCoor.c + offsets[i][1];
        if (isValid(newR, newC) && matrix[newR][newC] == 0) {
          pq.offer(new Coor(newR, newC, currCoor.step + 1));
          matrix[newR][newC] = 1;
        }
      }
    }
    return -1;
  }
}

class Coor {
  int r, c, step;

  Coor(int r, int c, int step) {
    this.r = r;
    this.c = c;
    this.step = step;
  }
}