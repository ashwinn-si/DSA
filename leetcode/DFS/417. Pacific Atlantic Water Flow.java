class Solution {
  int offsets[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
  int R, C;
  boolean pacificReach[][];
  boolean atlanticReach[][];

  boolean isValid(int currR, int currC) {
    return currR >= 0 && currR < R && currC >= 0 && currC < C;
  }

  void dfs(int currR, int currC, boolean reachMatrix[][], int matrix[][]) {
    if (reachMatrix[currR][currC]) {
      return;
    }
    reachMatrix[currR][currC] = true;

    for (int index = 0; index < 4; index++) {
      int newR = currR + offsets[index][0];
      int newC = currC + offsets[index][1];
      if (isValid(newR, newC) && matrix[newR][newC] >= matrix[currR][currC]) {
        dfs(newR, newC, reachMatrix, matrix);
      }
    }
  }

  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    R = matrix.length;
    C = matrix[0].length;
    pacificReach = new boolean[R][C];
    atlanticReach = new boolean[R][C];

    for (int row = 0; row < R; row++) {
      dfs(row, 0, pacificReach, matrix);
      dfs(row, C - 1, atlanticReach, matrix);
    }

    for (int col = 0; col < C; col++) {
      dfs(0, col, pacificReach, matrix);
      dfs(R - 1, col, atlanticReach, matrix);
    }

    List<List<Integer>> result = new ArrayList<>();
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (pacificReach[row][col] && atlanticReach[row][col]) {
          result.add(Arrays.asList(row, col));
        }
      }
    }
    return result;
  }
}