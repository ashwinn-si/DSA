class NumMatrix {
  private long prefixSum[][];

  public NumMatrix(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    this.prefixSum = new long[R][C + 1];
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        prefixSum[row][col + 1] = prefixSum[row][col] + matrix[row][col];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int result = 0;
    for (int row = row1; row <= row2; row++) {
      result += prefixSum[row][col2 + 1] - prefixSum[row][col1];
    }
    return result;
  }
}

// IMP OPTIMIZED APPOARCH
class NumMatrix {
  private long[][] pref;

  public NumMatrix(int[][] matrix) {
    int R = matrix.length, C = matrix[0].length;
    pref = new long[R + 1][C + 1];
    for (int r = 1; r <= R; r++) {
      for (int c = 1; c <= C; c++) {
        pref[r][c] = matrix[r - 1][c - 1]
            + pref[r - 1][c]
            + pref[r][c - 1]
            - pref[r - 1][c - 1];
      }
    }
  }

  public int sumRegion(int r1, int c1, int r2, int c2) {
    r1++;
    c1++;
    r2++;
    c2++; // shift to 1-based
    long sum = pref[r2][c2]
        - pref[r1 - 1][c2]
        - pref[r2][c1 - 1]
        + pref[r1 - 1][c1 - 1];
    return (int) sum;
  }
}

// UP AND LEFT ADD PANNI, DIAGONAL MINUS, ADD INDEX VALUE -> DURING BUILDING

// UP AND LEFT MINUS PANNI, DIAGONAL ADD, ADD INDEX VALUE -> DURING QUERYING