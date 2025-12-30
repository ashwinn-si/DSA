class Solution {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(s);
    Arrays.sort(g);
    int cPointer = s.length - 1;
    int count = 0;
    for (int index = g.length - 1; index >= 0; index--) {
      if (cPointer >= 0 && g[index] <= s[cPointer]) {
        count++;
        cPointer--;
      }
    }
    return count;
  }
}