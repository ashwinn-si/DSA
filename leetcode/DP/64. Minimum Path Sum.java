//try from top right to bottom left, change the movements, and try 
//! if there is unidirection then use DP not DFS

class Solution{
    public int minPathSum(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        int dp[][] = new int[R][C];
        
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(i == 0){
                    if(j == 0){
                        dp[i][j] = matrix[i][j];
                    }else{
                        dp[i][j] = dp[i][j-1] + matrix[i][j];
                    }
                }else if( j == 0){
                    dp[i][j] = matrix[i][j] + dp[i-1][j];
                }else{
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[R-1][C-1];
    }
}