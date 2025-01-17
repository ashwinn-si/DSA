class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for(int i = 0 ; i < N ; i++){
            for(int j = i+1 ; j < N ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0 ; i < N ; i++){
            int j = 0 ;
            int end = N-1;
            while( j < end){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][end];
                matrix[i][end] = temp;
                j++;
                end--;
            }
        }
    }
}