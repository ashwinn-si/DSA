class Solution {
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int rowValue[] = new int[R];
        int colValue[] = new int[C];
        for(int i = 0 ;i  < R; i++){
            for(int j = 0 ; j < C ; j++){
                if(matrix[i][j] == 0){
                    rowValue[i]++;
                    colValue[j]++;
                }
            }
        }
        
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(rowValue[i] != 0 || colValue[j] !=0){
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}