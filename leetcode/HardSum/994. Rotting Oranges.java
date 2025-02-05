class Solution {
    private boolean isFreshOrange(int i , int j , int matrix[][]){
        return (matrix[i][j] == 1);
    }

    private boolean boundaryChecker(int R, int C ,int i , int j){
        return (i >= 0 && i < R && j >= 0 && j < C);
    }

    private void freshOrangeToRottenOrange(Queue<Corr> rottenPosition, int[][] matrix, int R, int C, int freshOranges[]){
            Corr currCorr = rottenPosition.poll();
            int i = currCorr.i , j = currCorr.j ;
            int offsets[][] = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
            for(int k = 0 ; k < 4 ; k++){
                if(boundaryChecker(R , C, i+offsets[k][0] , j+offsets[k][1]) && isFreshOrange(i+offsets[k][0] , j+offsets[k][1] , matrix)){
                    matrix[i+offsets[k][0]][ j+offsets[k][1]] = 2;
                    rottenPosition.offer(new Corr(i + offsets[k][0], j+offsets[k][1]));
                    freshOranges[0]--;
                }
            }
    }

    public int orangesRotting(int[][] matrix) {
        Queue<Corr> rottenPosition = new LinkedList<>();
        int R = matrix.length, C = matrix[0].length;
        int days = 0;
        int freshOranges[] = new int[] {0};

        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(matrix[i][j] == 1) freshOranges[0]++;
                if(matrix[i][j] == 2){
                    rottenPosition.offer(new Corr(i,j));
                }
            }
        }

        //base case
        if(freshOranges[0] == 0 && rottenPosition.isEmpty()) return 0;

        while(!rottenPosition.isEmpty()){
            int size = rottenPosition.size();
            for(int i = 0; i < size ; i++){
                freshOrangeToRottenOrange(rottenPosition, matrix, R, C, freshOranges);
            }
            days++;
        }
        
        if(freshOranges[0] != 0) return -1;
        return days-1;
    }
}

class Corr{
    int i, j;
    Corr(int i ,int j){
        this.i = i;
        this.j = j;
    }
}