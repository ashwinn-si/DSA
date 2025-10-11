class Solution {
    int offsets[][]={{2, 1}, {2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {-2, 1}, {-2, -1}};
    int R, C;
    boolean isValid(int currR, int currC){
        return currR >= 0 && currR < R && currC >= 0 && currC < C;
    }

    boolean check(int currR, int currC, int matrix[][], int checkStep){
        if(checkStep == R * C){
            return true;
        }
        for(int index = 0; index < 8; index++){
            int newR = currR + offsets[index][0];
            int newC = currC + offsets[index][1];
            if(isValid(newR, newC) && matrix[newR][newC] == checkStep){
                return check(newR, newC, matrix, checkStep + 1);
            }
        }
        return false;
    }
    public boolean checkValidGrid(int[][] matrix) {
        R = matrix.length;
        C = matrix[0].length;
        if(matrix[0][0] != 0) return false;
        return check(0, 0, matrix, 1);
    }
}