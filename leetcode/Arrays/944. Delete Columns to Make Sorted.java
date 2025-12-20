class Solution {
  public int minDeletionSize(String[] strs) {
    int deleteCount = 0;
    int N = strs.length;
    for (int col = 0; col < strs[0].length(); col++) {
      for (int index = 1; index < N; index++) {
        if (strs[index - 1].charAt(col) > strs[index].charAt(col)) {
          deleteCount++;
          break;
        }
      }
    }
    return deleteCount;
  }
}