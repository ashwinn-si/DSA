class DSU {
  int n;
  int[] parent, rank;

  DSU(int n) {
    this.n = n;
    parent = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  public boolean union(int x, int y) {
    int px = findparent(x);
    int py = findparent(y);

    if (px == py)
      return true;
    if (rank[px] > rank[py]) {
      parent[py] = px;
    } else if (rank[px] < rank[py]) {
      parent[px] = py;
    } else {
      parent[py] = px;
      rank[px] = rank[px] + 1;
    }
    return false;
  }

  public int findparent(int x) {
    if (x != parent[x]) {
      parent[x] = findparent(parent[x]);
    }
    return parent[x];
  }
}

class Solution {
  int offsets[][] = new int[][] { { 0, 1 }, { 1, 0 } };
  int R, C;

  boolean isValid(int row, int col) {
    return row >= 0 && row < R && col >= 0 && col < C;
  }

  public boolean containsCycle(char[][] matrix) {
    R = matrix.length;
    C = matrix[0].length;
    DSU dsu = new DSU(R * C);
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        int u = row * C + col;
        for (int offset[] : offsets) {
          int newR = row + offset[0];
          int newC = col + offset[1];
          if (isValid(newR, newC) && matrix[row][col] == matrix[newR][newC]) {
            int v = newR * C + newC;
            if (dsu.findparent(u) == dsu.findparent(v)) {
              return true;
            }
            dsu.union(u, v);
          }
        }
      }
    }
    return false;
  }
}