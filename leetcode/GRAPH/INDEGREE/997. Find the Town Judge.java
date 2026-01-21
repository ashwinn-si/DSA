class Solution {
  public int findJudge(int n, int[][] trust) {
    int inDegree[] = new int[n];
    int outDegree[] = new int[n];
    for (int t[] : trust) {
      int u = t[0] - 1;
      int v = t[1] - 1;
      inDegree[v]++;
      outDegree[u]++;
    }
    for (int index = 0; index < n; index++) {
      if (inDegree[index] == n - 1 && outDegree[index] == 0) {
        return index + 1;
      }
    }
    return -1;
  }
}