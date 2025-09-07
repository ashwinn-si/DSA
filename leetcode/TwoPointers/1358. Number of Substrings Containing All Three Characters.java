class Solution {
  public int numberOfSubstrings(String s) {
    int a = -1, b = -1, c = -1;
    int N = s.length();
    int count = 0;
    for (int i = 0; i < N; i++) {
      char ch = s.charAt(i);
      if (ch == 'a') {
        a = i;
      } else if (ch == 'b') {
        b = i;
      } else {
        c = i;
      }
      if (a != -1 && b != -1 && c != -1) {
        count += 1 + Math.min(a, Math.min(b, c));
      }
    }
    return count;
  }
}