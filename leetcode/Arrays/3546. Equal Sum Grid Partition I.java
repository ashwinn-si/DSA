class Solution {
    public boolean canPartitionGrid(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        long sumCol[] = new long[C];
        long sumRow[] = new long[R];
        long total = 0L;

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                sumCol[col] += matrix[row][col];
                sumRow[row] += matrix[row][col];
                total += matrix[row][col];
            }
        }

        long curr = 0L;
        for (int index = 0; index < R; index++) {
            curr += sumRow[index];
            if (curr == total - curr) {
                return true;
            }
        }
        curr = 0L;
        for (int index = 0; index < C; index++) {
            curr += sumCol[index];
            if (curr == total - curr) {
                return true;
            }
        }

        return false;
    }
}
