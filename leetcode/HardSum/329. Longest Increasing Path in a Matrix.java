class Solution {
    int offsets[][] = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

    private boolean isLower(int currR, int currC, int nextR, int nextC, int matrix[][]){
        return (matrix[currR][currC] < matrix[nextR][nextC]);
    }

    private boolean boundaryChecker(int R, int C, int currR, int currC){
        return (currR >=0 && currR < R && currC >=0 && currC < C);
    }

    private int dfs(int matrix[][], int dp[][],int R, int C, int currR, int currC){
        //base case
        if(dp[currR][currC] != 0){
            return dp[currR][currC];
        }

        int maxPath = 0;
        for(int i = 0 ; i < 4 ; i++){
            int nextR = offsets[i][0] + currR;
            int nextC = offsets[i][1] + currC;
            if(boundaryChecker(R, C, nextR, nextC) && isLower(currR, currC, nextR, nextC, matrix)){
                maxPath = Math.max(maxPath, dfs(matrix, dp, R, C, nextR, nextC));
            }
        }
        dp[currR][currC] = maxPath+1;
        return dp[currR][currC];
    }

    public int longestIncreasingPath(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        int dp[][] = new int[R][C];
        int result = 0;
        
        for(int i = 0 ; i < R  ; i++){
            for(int j = 0 ; j < C ; j++){
                if(dp[i][j] == 0){
                    dfs(matrix, dp, R, C, i, j);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}