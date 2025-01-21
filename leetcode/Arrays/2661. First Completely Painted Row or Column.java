class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer , Position> hash = new HashMap<>();
        int R = mat.length;
        int C = mat[0].length;
        int rowT[] = new int[R];
        int colT[] = new int[C];
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                hash.put(mat[i][j] , new Position(i , j));
            }
        }

        for(int i = 0 ; i < arr.length ; i++){
            Position p = hash.get(arr[i]);
            rowT[p.x]++;
            colT[p.y]++;
            if(rowT[p.x] == C || colT[p.y] == R){
                return i;
            }
        }
        return -1;
    }
}
class Position{
    int x , y;
    Position(int x , int y){
        this.x = x;
        this.y = y;
    }
}