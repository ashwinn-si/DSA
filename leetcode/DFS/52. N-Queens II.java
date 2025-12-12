class Solution {
  int totalCount;

  boolean isValid(int row, int col, int checker[], int n) {
    return (((checker[0] & (1 << row)) == 0) && ((checker[1] & (1 << col)) == 0)
        && ((checker[2] & (1 << (row - col + (n - 1)))) == 0) && ((checker[3] & (1 << (row + col)))) == 0);
  }

  boolean dfs(int currR, int checker[], int n) {
    if (currR == n) {
      return true;
    }
    for (int col = 0; col < n; col++) {
      if (isValid(currR, col, checker, n)) {
        checker[0] = checker[0] | (1 << currR);
        checker[1] = checker[1] | (1 << col);
        checker[2] = checker[2] | (1 << (currR - col + (n - 1)));
        checker[3] = checker[3] | (1 << (currR + col));
        if (dfs(currR + 1, checker, n)) {
          totalCount++;
        }
        checker[0] = checker[0] ^ (1 << currR);
        checker[1] = checker[1] ^ (1 << col);
        checker[2] = checker[2] ^ (1 << (currR - col + (n - 1)));
        checker[3] = checker[3] ^ (1 << (currR + col));
      }
    }
    return false;
  }

  public int totalNQueens(int n) {
    int checker[] = new int[] { 0, 0, 0, 0 };
    totalCount = 0;
    dfs(0, checker, n);
    return totalCount;
  }
}