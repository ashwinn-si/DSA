class Solution {
  public boolean hasSameDigits(String s) {
    int N = s.length();
    int matrix[][] = new int[N - 1][N];
    int index = 0;
    for (char ch : s.toCharArray()) {
      matrix[0][index++] = ch - '0';
    }
    for (int row = 1; row < N - 1; row++) {
      for (index = 0; index < N - row; index++) {
        matrix[row][index] = (matrix[row - 1][index] + matrix[row - 1][index + 1]) % 10;
      }
    }
    return matrix[N - 2][0] == matrix[N - 2][1];
  }
}