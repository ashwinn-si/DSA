class Solution {
  private final int offsets[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
  private final int INF = 1_000_000_000;

  boolean isValid(int currR, int currC, int R, int C) {
    return currR >= 0 && currR < R && currC >= 0 && currC < C;
  }

  public int minimumEffortPath(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    int result[][] = new int[R][C];
    for (int index = 0; index < R; index++) {
      Arrays.fill(result[index], INF);
    }
    PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
    pq.offer(new Element(0, 0, 0));
    result[0][0] = 0;
    while (!pq.isEmpty()) {
      Element currCoor = pq.poll();
      if (result[currCoor.row][currCoor.col] < currCoor.weight) {
        continue;
      }
      for (int index = 0; index < 4; index++) {
        int newR = currCoor.row + offsets[index][0];
        int newC = currCoor.col + offsets[index][1];
        if (!isValid(newR, newC, R, C)) {
          continue;
        }
        int newWeight = Math.abs(matrix[newR][newC] - matrix[currCoor.row][currCoor.col]);
        newWeight = Math.max(newWeight, currCoor.weight);
        if (result[newR][newC] == INF || result[newR][newC] > newWeight) {
          result[newR][newC] = newWeight;
          pq.offer(new Element(newR, newC, newWeight));
        }
      }
    }
    return result[R - 1][C - 1];
  }
}

class Element {
  int row, col, weight;

  Element(int row, int col, int weight) {
    this.row = row;
    this.col = col;
    this.weight = weight;
  }
}