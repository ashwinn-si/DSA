class Solution {
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    int inDegree[] = new int[n];
    for (List<Integer> edge : edges) {
      int u = edge.get(0);
      int v = edge.get(1);
      inDegree[v]++;
    }
    List<Integer> result = new ArrayList<>();
    for (int index = 0; index < n; index++) {
      if (inDegree[index] == 0) {
        result.add(index);
      }
    }
    return result;
  }
}