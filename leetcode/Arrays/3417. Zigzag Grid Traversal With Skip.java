class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> res = new ArrayList<>();
        int R = grid.length, C = grid[0].length;
        for(int i = 0 ; i < R ; i++){
            if(i % 2 == 0){
                for(int j = 0 ;j < C ; j+=2){
                    res.add(grid[i][j]);
                }
            }else{
                int j = C % 2 == 0 ? C-1 : C-2;
                for(; j >= 0 ; j-=2){
                    res.add(grid[i][j]);
                }
            }
        }
        return res;
    }
}