class Solution {
  public int[][] sortMatrix(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    for (int i = 0; i < R; i++) {
      int currR = i, currC = 0;
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      while (currR >= 0 && currR < R && currC >= 0 && currC < C) {
        pq.offer(matrix[currR++][currC++]);
      }
      currR = i;
      currC = 0;
      while (currR >= 0 && currR < R && currC >= 0 && currC < C) {
        matrix[currR++][currC++] = pq.poll();
      }
    }
    for (int i = 1; i < C; i++) {
      int currR = 0, currC = i;
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      while (currR >= 0 && currR < R && currC >= 0 && currC < C) {
        pq.offer(matrix[currR++][currC++]);
      }
      currR = 0;
      currC = i;
      while (currR >= 0 && currR < R && currC >= 0 && currC < C) {
        matrix[currR++][currC++] = pq.poll();
      }
    }
    return matrix;

  }
}