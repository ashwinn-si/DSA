class Solution {
  public int celebrity(int[][] matrix) {
    int R = matrix.length;
    int C = matrix[0].length;
    int mapMatrix[][] = new int[R][2]; // 0 -> no of following | 1 -> no of followers
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (matrix[row][col] == 0)
          continue;
        mapMatrix[row][0]++;
        mapMatrix[col][1]++;
      }
    }
    for (int index = 0; index < R; index++) {
      // if(mapMatrix[index][0] == 0 && mapMatrix[index][1] == R - 1){
      // return index;
      // }
      System.out.println(Arrays.toString(mapMatrix[index]));
    }
    return -1;
  }
}