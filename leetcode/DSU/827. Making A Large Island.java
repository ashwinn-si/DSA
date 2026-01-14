class DSU {
  int[] parent;
  int[] rank;
  int[] components;
  int n;

  DSU(int n) {
    parent = new int[n];
    rank = new int[n];
    components = new int[n];
    this.n = n;
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      components[i] = 1;
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
      components[uP] += components[vP];
      components[vP] = 1;
      rank[uP]++;
    } else if (rank[uP] > rank[vP]) {
      parent[vP] = uP;
      components[uP] += components[vP];
      components[vP] = 1;
    } else {
      parent[uP] = vP;
      components[vP] += components[uP];
      components[uP] = 1;
    }
  }

  int getComponents(int u) {
    return components[findParent(u)];
  }
}

class Solution {
  boolean isValid(int row, int col, int R, int C) {
    return row >= 0 && row < R && col >= 0 && col < C;
  }

  public int largestIsland(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    DSU dsu = new DSU(R * C);
    int offsets[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int result = 0;

    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (matrix[row][col] == 0)
          continue;
        int u = row * C + col;
        for (int offset[] : offsets) {
          int newR = row + offset[0];
          int newC = col + offset[1];
          if (isValid(newR, newC, R, C) && matrix[newR][newC] == 1) {
            int v = newR * C + newC;
            dsu.union(u, v);
          }
        }
        result = Math.max(result, dsu.getComponents(u));
      }
      System.out.println(Arrays.toString(matrix[row]));
    }
    System.out.println(Arrays.toString(dsu.components));
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (matrix[row][col] == 1)
          continue;
        int u = row * C + col;
        HashSet<Integer> seen = new HashSet<>();
        int count = 1;

        for (int offset[] : offsets) {
          int newR = row + offset[0];
          int newC = col + offset[1];
          if (isValid(newR, newC, R, C) && matrix[newR][newC] == 1) {
            int v = newR * C + newC;
            int root = dsu.findParent(v);

            if (!seen.contains(root)) {
              seen.add(root);
              count += dsu.getComponents(v);
            }
          }
        }

        result = Math.max(result, count);
      }
    }
    return result;
  }
}