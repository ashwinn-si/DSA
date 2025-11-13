class Solution {
  public int maxOperations(String s) {
    int totalNoOnes = 0;
    int n = s.length();
    int res = 0;
    int index = 0;
    while (index < n) {
      int ch = s.charAt(index) - '0';
      if (ch == 0) {
        int dummyPointer = index + 1;
        while (dummyPointer < n && s.charAt(dummyPointer) == '0') {
          dummyPointer++;
        }
        index = dummyPointer - 1;
        res += totalNoOnes;
      } else {
        totalNoOnes++;
      }
      index++;
    }
    return res;
  }
}