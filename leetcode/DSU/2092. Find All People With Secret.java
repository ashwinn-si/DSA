class DSU {
  List<Integer> rank = new ArrayList<>();
  List<Integer> parent = new ArrayList<>();

  DSU(int n) {
    for (int index = 0; index < n; index++) {
      rank.add(0);
      parent.add(index);
    }
  }

  int findParent(int node) {
    if (parent.get(node) == node) {
      return node;
    }
    int ultimateParent = findParent(parent.get(node));
    parent.set(node, ultimateParent);
    return ultimateParent;
  }

  boolean find(int u, int v) {
    return findParent(u) == findParent(v);
  }

  void unionRank(int u, int v) {
    int upU = findParent(u);
    int upV = findParent(v);
    int rankU = rank.get(upU);
    int rankV = rank.get(upV);
    if (rankU == rankV) {
      rank.set(upU, rank.get(upU) + 1);
      parent.set(upV, upU);
    } else if (rankU > rankV) {
      parent.set(upV, upU);
    } else {
      parent.set(upU, upV);
    }
  }
}

class Solution {
  public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
    Arrays.sort(meetings, (a, b) -> a[2] != b[2] ? Integer.compare(a[2], b[2]) : Integer.compare(a[0], b[0]));
    DSU dsu = new DSU(n);
    dsu.unionRank(0, firstPerson);
    for (int i = 0; i < meetings.length;) {
      int time = meetings[i][2];
      List<int[]> batch = new ArrayList<>();

      while (i < meetings.length && meetings[i][2] == time) {
        batch.add(meetings[i]);
        i++;
      }

      // Union all meetings at this time
      for (int[] m : batch) {
        dsu.unionRank(m[0], m[1]);
      }

      // Rollback people who are not connected to 0
      for (int[] m : batch) {
        if (!dsu.find(0, m[0])) {
          dsu.parent.set(m[0], m[0]);
          dsu.parent.set(m[1], m[1]);
        }
      }
    }
    List<Integer> result = new ArrayList<>();
    for (int index = 0; index < n; index++) {
      if (dsu.find(0, index)) {
        result.add(index);
      }
    }
    return result;
  }
}