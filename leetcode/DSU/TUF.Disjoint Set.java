class DisjointSet {
  List<Integer> parent = new ArrayList<>();
  List<Integer> rank = new ArrayList<>();
  List<Integer> size = new ArrayList<>();

  public DisjointSet(int n) {
    for (int index = 0; index <= n; index++) {
      parent.add(index);
      rank.add(0);
      size.add(1);
    }
  }

  public boolean find(int u, int v) {
    return findParent(u) == findParent(v);
  }

  public int findParent(int node) {
    if (parent.get(node) == node) {
      return node;
    }
    int parentNode = findParent(parent.get(node));
    parent.set(node, parentNode);
    return parentNode;
  }

  public void unionByRank(int u, int v) {
    // finding the ultimate parent
    int upU = findParent(u);
    int upV = findParent(v);
    // finding the rank of ultimate parent
    int rankUpU = rank.get(upU);
    int rankUpV = rank.get(upV);

    if (rankUpU == rankUpV) {
      // we can chose any one and update the rank
      rank.set(upU, rank.get(upU) + 1);
      parent.set(upV, upU);
    } else if (rankUpU > rankUpV) {
      // if the rank of u is bigger than v
      parent.set(upV, upU);
    } else {
      // the rank of v is bigger than u
      parent.set(upU, upV);
    }
  }

  public void unionBySize(int u, int v) {
    // finding the ultimate parent
    int upU = findParent(u);
    int upV = findParent(v);
    // finding the rank of ultimate parent
    int sizeUpU = size.get(upU);
    int sizeUpV = size.get(upV);

    if (sizeUpU == sizeUpV) {
      // we can chose any one and update the rank
      size.set(upU, size.get(upU) + 1);
      parent.set(upV, upU);
    } else if (sizeUpU > sizeUpV) {
      // if the rank of u is bigger than v
      parent.set(upV, upU);
    } else {
      // the rank of v is bigger than u
      parent.set(upU, upV);
    }
  }
}
