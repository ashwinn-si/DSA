class Solution {
    private void  dfs(int N, int city, int matrix[][], boolean visited[]){
        visited[city] = true;
        for(int otherCity = 0; otherCity < N ; otherCity++){
            if(!visited[otherCity] && matrix[city][otherCity] == 1){
                dfs(N , otherCity, matrix, visited);
            }
        }
    }
    public int findCircleNum(int[][] matrix) {
        int N = matrix.length, provinces = 0;
        boolean visited[] = new boolean[N];
        for(int city = 0 ; city < N ; city++){
            if(!visited[city]){
                provinces++;
                dfs(N , city, matrix, visited);
            }
        }
        return provinces;
    }
}