class DSU {
  int[] parent;
  int[] rank;
  int n;

  DSU(int n) {
    parent = new int[n];
    rank = new int[n];
    this.n = n;
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  boolean find(int u, int v) {
    return findParent(u) == findParent(v);
  }

  int findParent(int node) {
    if (parent[node] == node) {
      return node;
    }
    parent[node] = findParent(parent[node]);
    return parent[node];
  }

  void union(int u, int v) {
    int uP = findParent(u);
    int vP = findParent(v);
    if (uP == vP)
      return;

    if (rank[uP] == rank[vP]) {
      parent[vP] = uP;
      rank[uP]++;
    } else if (rank[uP] > rank[vP]) {
      parent[vP] = uP;
    } else {
      parent[uP] = vP;
    }
  }
}

class Solution {
  boolean isValid(int r, int c, int R, int C) {
    return r >= 0 && r < R && c >= 0 && c < C;
  }

  public List<Integer> numOfIslands(int n, int m, int[][] A) {
    // 0 -> water | 1 -> something else is there;
    DSU dsu = new DSU(n * m);
    int matrix[][] = new int[n][m];
    int offsets[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    List<Integer> answer = new ArrayList<>();
    int count = 0;
    for (int iter[] : A) {
      int row = iter[0];
      int col = iter[1];
      int u = row * m + col;
      if (matrix[row][col] != 0) {
        answer.add(count);
        continue;
      }
      matrix[row][col] = 1;
      count++;
      for (int offset[] : offsets) {
        int newR = row + offset[0];
        int newC = col + offset[1];
        if (!isValid(newR, newC, n, m))
          continue;
        if (matrix[newR][newC] == 0)
          continue;
        int v = newR * m + newC;
        if (dsu.findParent(u) != dsu.findParent(v)) {
          count--;
          dsu.union(u, v);
        }
      }

      answer.add(count);
    }
    return answer;
  }
}
