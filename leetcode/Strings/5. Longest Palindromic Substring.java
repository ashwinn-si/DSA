class Solution {
    public String longestPalindrome(String string) {
        int N = string.length();
        int matrix[][] = new int[N][N];
        for(int index = 0; index < N; index++){
            matrix[index][index] = 1;
        }
        int result = 1;
        int endIndex = 1;
        for(int index = 1; index < N; index++){
            int row = 0;
            int col = index;
            while(row < N && col < N){
                if(string.charAt(row) == string.charAt(col)){
                    if(index == 1 || (matrix[row + 1][col - 1] == 1)){
                        matrix[row][col] = 1;
                        if(result < index + 1){
                            result = index + 1;
                            endIndex = col + 1;
                        }
                    }
                }
                row++;
                col++;
            }
        }
        int startIndex = Math.max(0, endIndex - result);
        return string.substring(startIndex, endIndex);
    }
}