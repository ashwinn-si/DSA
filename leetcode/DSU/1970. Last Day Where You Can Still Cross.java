class DSU {
  int parent[];
  int rank[];
  int n;

  DSU(int n) {
    this.n = n;
    this.parent = new int[n];
    this.rank = new int[n];
    for (int index = 0; index < n; index++) {
      parent[index] = index;
    }
  }

  boolean find(int u, int v) {
    return findParent(u) == findParent(v);
  }

  int findParent(int node) {
    if (parent[node] != node) {
      parent[node] = findParent(parent[node]);
    }
    return parent[node];
  }

  void union(int u, int v) {
    int pU = findParent(u);
    int pV = findParent(v);
    if (pU == pV) {
      return;
    }
    int rU = rank[pU];
    int rV = rank[pV];
    if (rU > rV) {
      parent[pV] = pU;
    } else if (rU < rV) {
      parent[pU] = pV;
    } else {
      parent[pV] = pU;
      rank[pU]++;
    }
  }
}

class Solution {
  public int latestDayToCross(int row, int col, int[][] cells) {
    int totalCells = row * col;
    int TOP = totalCells;
    int BOTTOM = totalCells + 1;
    int offsets[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    DSU dsu = new DSU(totalCells + 2);
    boolean land[][] = new boolean[row][col];

    // initial we are considering all are water
    for (int index = cells.length - 1; index >= 0; index--) {
      int r = cells[index][0] - 1;
      int c = cells[index][1] - 1;
      // marking it as land
      land[r][c] = true;

      int u = r * col + c;
      for (int offset[] : offsets) {
        int newR = r + offset[0];
        int newC = c + offset[1];
        if (newR >= 0 && newR < row && newC >= 0 && newC < col && land[newR][newC]) {
          int v = newR * col + newC;
          dsu.union(u, v);
        }
      }

      if (r == 0) {
        dsu.union(u, TOP);
      }
      if (r == row - 1) {
        dsu.union(u, BOTTOM);
      }
      if (dsu.find(TOP, BOTTOM)) {
        return index;
      }
    }
    return 0;
  }
}
