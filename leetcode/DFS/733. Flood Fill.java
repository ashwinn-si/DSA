class Solution {
    private int offsets[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private boolean visited[][];
    private int R = 0, C = 0;

    public boolean isValid(int currR, int currC) {
        return 0 <= currR && currR < R && 0 <= currC && currC < C;
    }

    public void dfs(int matrix[][], int currR, int currC, int color, int target) {
        for (int index = 0; index < 4; index++) {
            int newR = currR + offsets[index][0];
            int newC = currC + offsets[index][1];
            if (isValid(newR, newC) && matrix[newR][newC] == target && !visited[newR][newC]) {
                matrix[newR][newC] = color;
                visited[newR][newC] = true;
                dfs(matrix, newR, newC, color, target);
            }
        }
    }

    public int[][] floodFill(int[][] matrix, int sr, int sc, int color) {
        R = matrix.length;
        C = matrix[0].length;
        visited = new boolean[R][C];
        dfs(matrix, sr, sc, color, matrix[sr][sc]);
        matrix[sr][sc] = color;
        return matrix;
    }
}