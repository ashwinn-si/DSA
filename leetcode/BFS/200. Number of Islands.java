class Solution {
  int R, C;

  boolean isValid(int currR, int currC) {
    return currR >= 0 && currR < R && currC >= 0 && currC < C;
  }

  public int numIslands(char[][] matrix) {
    R = matrix.length;
    C = matrix[0].length;
    Queue<Coor> pq = new LinkedList<>();
    int result = 0;
    int[][] offsets = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (matrix[i][j] == '0')
          continue;
        pq.offer(new Coor(i, j));
        matrix[i][j] = '0';
        result++;
        while (!pq.isEmpty()) {
          Coor obj = pq.poll();
          int currR = obj.r;
          int currC = obj.c;
          for (int index = 0; index < 4; index++) {
            int newR = offsets[index][0] + currR;
            int newC = offsets[index][1] + currC;
            if (isValid(newR, newC) && matrix[newR][newC] == '1') {
              matrix[newR][newC] = '0';
              pq.offer(new Coor(newR, newC));
            }
          }
        }
      }
    }
    return result;
  }
}

class Coor {
  int r, c;

  Coor(int r, int c) {
    this.r = r;
    this.c = c;
  }
}