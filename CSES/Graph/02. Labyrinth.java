import java.util.*;

class Main {
  static int R, C;
  static int offsets[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  static boolean isValid(int currR, int currC) {
    return currR >= 0 && currR < R && currC >= 0 && currC < C;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    R = sc.nextInt();
    C = sc.nextInt();

    int startR = -1, startC = -1, endR = -1, endC = -1;

    int matrix[][] = new int[R][C];

    for (int row = 0; row < R; row++) {
      int col = 0;
      while (col < C) {
        String token = sc.next();
        for (int k = 0; k < token.length() && col < C; k++) {
          char ch = token.charAt(k);
          if (ch == 'A' || ch == 'B') {
            matrix[row][col] = 1;
            if (ch == 'A') {
              startR = row;
              startC = col;
            } else {
              endR = row;
              endC = col;
            }
            col++;
            continue;
          }
          matrix[row][col++] = (ch == '#') ? 2 : 1;
        }
      }
    }

    // Quick check
    if (startR == -1 || endR == -1) {
      System.out.println("NO");
      sc.close();
      return;
    }

    // visited and predecessor arrays to avoid storing path on every node
    boolean[][] visited = new boolean[R][C];
    int[][] prevR = new int[R][C];
    int[][] prevC = new int[R][C];
    char[][] prevMove = new char[R][C];

    for (int i = 0; i < R; i++) {
      Arrays.fill(prevR[i], -1);
      Arrays.fill(prevC[i], -1);
    }

    ArrayDeque<Integer> q = new ArrayDeque<>();
    int startCode = startR * C + startC;
    int endCode = endR * C + endC;
    q.add(startCode);
    visited[startR][startC] = true;

    // mapping of offsets to move chars (same order as offsets)
    char[] moveChar = new char[] { 'R', 'L', 'D', 'U' };

    boolean found = false;
    while (!q.isEmpty()) {
      int code = q.poll();
      int r = code / C;
      int c = code % C;
      if (r == endR && c == endC) {
        found = true;
        break;
      }
      for (int index = 0; index < 4; index++) {
        int newR = r + offsets[index][0];
        int newC = c + offsets[index][1];
        if (isValid(newR, newC) && !visited[newR][newC] && matrix[newR][newC] == 1) {
          visited[newR][newC] = true;
          prevR[newR][newC] = r;
          prevC[newR][newC] = c;
          prevMove[newR][newC] = moveChar[index];
          q.add(newR * C + newC);
        }
      }
    }

    if (!found) {
      System.out.println("NO");
      sc.close();
      return;
    }

    // reconstruct path from end to start
    StringBuilder sb = new StringBuilder();
    int cr = endR, cc = endC;
    while (!(cr == startR && cc == startC)) {
      char m = prevMove[cr][cc];
      sb.append(m);
      int pr = prevR[cr][cc];
      int pc = prevC[cr][cc];
      cr = pr;
      cc = pc;
    }
    sb.reverse();
    System.out.println("YES");
    System.out.println(sb.length());
    System.out.println(sb.toString());

    sc.close();
  }

  static class Coor {
    int x, y;
    StringBuffer str;

    Coor(int x, int y, StringBuffer str) {
      this.x = x;
      this.y = y;
      this.str = str;
    }
  }

}