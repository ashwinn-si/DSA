import java.util.*;

class Main {
  static int R, C;
  static int offsets[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  static boolean isValid(int currR, int currC) {
    return currR >= 0 && currR < R && currC >= 0 && currC < C;
  }

  static void dfs(int currR, int currC, int matrix[][]) {
    matrix[currR][currC] = 2;
    for (int index = 0; index < 4; index++) {
      int newR = currR + offsets[index][0];
      int newC = currC + offsets[index][1];
      if (isValid(newR, newC) && matrix[newR][newC] == 1) {
        dfs(newR, newC, matrix);
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    R = sc.nextInt();
    C = sc.nextInt();
    sc.nextLine();
    int matrix[][] = new int[R][C];
    for (int row = 0; row < R; row++) {
      String str = sc.nextLine();
      for (int col = 0; col < C; col++) {
        matrix[row][col] = str.charAt(col) == '#' ? 2 : 1;
      }
    }

    int count = 0;
    for (int row = 0; row < R; row++) {
      for (int col = 0; col < C; col++) {
        if (matrix[row][col] == 1) {
          dfs(row, col, matrix);
          count++;
        }
      }
    }
    System.out.println(count);
    sc.close();
  }
}