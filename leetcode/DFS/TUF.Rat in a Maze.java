import java.util.*;

class Solution {
  private int R, C;
  private List<String> result;
  private int[][] matrix;

  private boolean isValid(int row, int col) {
    return row >= 0 && row < R && col >= 0 && col < C;
  }

  private void dfs(int currR, int currC, StringBuilder path, boolean[][] visited) {
    if (currR == R - 1 && currC == C - 1) {
      result.add(path.toString());
      return;
    }

    char[] moves = { 'D', 'L', 'R', 'U' };
    int[][] offsets = {
        { 1, 0 }, // D
        { 0, -1 }, // L
        { 0, 1 }, // R
        { -1, 0 } // U
    };

    for (int i = 0; i < moves.length; ++i) {
      char key = moves[i];
      int newR = currR + offsets[i][0];
      int newC = currC + offsets[i][1];
      if (isValid(newR, newC) && !visited[newR][newC] && matrix[newR][newC] == 1) {
        path.append(key);
        visited[newR][newC] = true;
        dfs(newR, newC, path, visited);
        visited[newR][newC] = false;
        path.deleteCharAt(path.length() - 1);
      }
    }
  }

  public List<String> findPath(int[][] matrix) {
    this.matrix = matrix;
    result = new ArrayList<>();
    if (matrix == null || matrix.length == 0)
      return result;

    R = matrix.length;
    C = matrix[0].length;

    if (matrix[0][0] == 0 || matrix[R - 1][C - 1] == 0)
      return result;

    boolean[][] visited = new boolean[R][C];
    visited[0][0] = true;
    dfs(0, 0, new StringBuilder(), visited);
    return result;
  }
}
