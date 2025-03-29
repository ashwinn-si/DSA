class Solution {
    private int R = 0, C = 0;
    private int[][] offsets = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private boolean[][] visitedMatrix;

    private boolean boundaryChecker(int currR, int currC) {
        return 0 <= currR && currR < R && 0 <= currC && currC < C;
    }

    private int dfs(int matrix[][], int currR, int currC) {
        int area = 1;
        for (int index = 0; index < 4; index++) {
            int newR = currR + offsets[index][0];
            int newC = currC + offsets[index][1];
            if (boundaryChecker(newR, newC) && !visitedMatrix[newR][newC] && matrix[newR][newC] == 1) {
                visitedMatrix[newR][newC] = true;
                area += dfs(matrix, newR, newC);
            }
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] matrix) {
        R = matrix.length;
        C = matrix[0].length;
        visitedMatrix = new boolean[R][C];
        int maxArea = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 1 && !visitedMatrix[i][j]) {
                    visitedMatrix[i][j] = true;
                    int currMatrixArea = dfs(matrix, i, j);
                    maxArea = Math.max(currMatrixArea, maxArea);
                }
            }
        }
        return maxArea;
    }
}