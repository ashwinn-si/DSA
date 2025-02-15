class Solution {
    int offsets[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    private boolean boundaryChecker(int currI, int currJ,int R, int C){
        return (0 <= currI && currI < R && 0 <= currJ && currJ < C);
    }

    private boolean dfs(char matrix[][], boolean visited[][], String word, int index,int R, int C, int len, int currI, int currJ){
        visited[currI][currJ] = true;
        if(len == index){
            return true;
        }
        boolean result = false;
        for(int i = 0 ; i < 4 ; i++){
            int adjI = currI + offsets[i][0];
            int adjJ = currJ + offsets[i][1];
            if(boundaryChecker(adjI, adjJ, R, C) && !visited[adjI][adjJ] && matrix[adjI][adjJ] == word.charAt(index)){
                result = result | dfs(matrix, visited, word, index+1, R, C, len, adjI, adjJ);
            }
        }
        visited[currI][currJ] = false;
        return result;
        
    }

    public boolean exist(char[][] matrix, String word) {
        int R = matrix.length, C = matrix[0].length, len = word.length();
        boolean result = false;
        boolean visited[][] = new boolean[R][C];
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(matrix[i][j] == word.charAt(0)){
                    if(dfs(matrix, visited, word, 1, R, C, len, i,j)){
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }   
        return result;
    }
}   