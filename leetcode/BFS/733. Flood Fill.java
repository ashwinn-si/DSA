class Solution {
  int R, C;

  boolean isValid(int currR, int currC) {
    return currR >= 0 && currR < R && currC >= 0 && currC < C;
  }

  public int[][] floodFill(int[][] matrix, int sr, int sc, int color) {
    if (matrix[sr][sc] == color)
      return matrix;
    R = matrix.length;
    C = matrix[0].length;
    Queue<Coor> pq = new LinkedList<>();
    int currColor = matrix[sr][sc];
    pq.offer(new Coor(sr, sc));
    matrix[sr][sc] = color;
    int offsets[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    while (!pq.isEmpty()) {
      Coor obj = pq.poll();
      int currR = obj.r;
      int currC = obj.c;
      for (int i = 0; i < 4; i++) {
        int newR = currR + offsets[i][0];
        int newC = currC + offsets[i][1];
        if (isValid(newR, newC) && matrix[newR][newC] == currColor) {
          matrix[newR][newC] = color;
          pq.offer(new Coor(newR, newC));
        }
      }
    }
    return matrix;

  }
}

class Coor {
  int r, c;

  Coor(int r, int c) {
    this.r = r;
    this.c = c;
  }
}