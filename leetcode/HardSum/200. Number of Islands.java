class Solution {
    private boolean boundaryChecker(int R , int C ,int i , int j){
        return (i >= 0 && i < R && j >= 0 && j < C);
    }

    private boolean isIsland(int i , int j , char matrix[][]){
        return matrix[i][j] == '1';
    }

    private void dfs(char matrix[][], int R , int C, int row , int col){
        int [][] offsets = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int k = 0 ; k < 4 ; k++){
            if(boundaryChecker(R , C , row + offsets[k][0] , col + offsets[k][1]) && isIsland( row + offsets[k][0] , col + offsets[k][1] , matrix)){
                matrix[row + offsets[k][0]][col + offsets[k][1]] = '0';
                dfs(matrix, R , C, row + offsets[k][0] , col + offsets[k][1]);
            }
        }
    }

    public int numIslands(char[][] matrix) {
        int R = matrix.length , C = matrix[0].length, islandCount = 0;
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(isIsland(i , j , matrix)){
                    dfs(matrix, R, C ,i ,j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
}