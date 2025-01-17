class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int R = matrix.length;
        int C = matrix[0].length;
        int left = 0;
        int right = C-1;
        int top = 0;
        int bottom = R-1;
        while(left <= right && top <= bottom){
            for(int i = left ; i <= right ; i++){
                res.add(matrix[top][i]);
            }
            top++;
            for(int i = top ; i <= bottom ; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom){
                for(int i = right ; i >= left ; i--){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left <= right){
                for(int i = bottom ; i >= top ; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}