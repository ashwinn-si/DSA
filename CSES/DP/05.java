import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Main {
  static class FastScanner {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0, len = 0;

    private int read() throws RuntimeException {
      if (ptr >= len) {
        try {
          len = in.read(buffer);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
        ptr = 0;
        if (len <= 0)
          return -1;
      }
      return buffer[ptr++];
    }

    int nextInt() {
      int c = read();
      while (c <= ' ') {
        if (c == -1)
          throw new NoSuchElementException();
        c = read();
      }
      int sign = 1;
      if (c == '-') {
        sign = -1;
        c = read();
      }
      int val = 0;
      while (c > ' ') {
        val = val * 10 + (c - '0');
        c = read();
      }
      return val * sign;
    }

    long nextLong() {
      int c = read();
      while (c <= ' ') {
        if (c == -1)
          throw new NoSuchElementException();
        c = read();
      }
      int sign = 1;
      if (c == '-') {
        sign = -1;
        c = read();
      }
      long val = 0;
      while (c > ' ') {
        val = val * 10 + (c - '0');
        c = read();
      }
      return val * sign;
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String next() {
      StringBuilder sb = new StringBuilder();
      int c = read();
      while (c <= ' ') {
        if (c == -1)
          throw new NoSuchElementException();
        c = read();
      }
      while (c > ' ') {
        sb.append((char) c);
        c = read();
      }
      return sb.toString();
    }

    String nextLine() {
      StringBuilder sb = new StringBuilder();
      int c = read();
      while (c != '\n' && c != -1) {
        sb.append((char) c);
        c = read();
      }
      return sb.toString();
    }

    void close() {
      try {
        in.close();
      } catch (IOException e) {
        // ignore
      }
    }
  }

  public static void main(String[] args) {
    FastScanner sc = new FastScanner();
    int N = sc.nextInt();
    int MOD = 1_000_000_007;
    char matrix[][] = new char[N][N];
    for (int index = 0; index < N; index++) {
      String str = sc.nextLine();
      for (int col = 0; col < N; col++) {
        matrix[index][col] = str.charAt(col);
      }
    }
    if (matrix[0][0] == '*') {
      System.out.print(0);
      return;
    }
    int dp[][] = new int[N + 1][N + 1];
    dp[1][1] = 1;
    for (int row = 1; row <= N; row++) {
      for (int col = 1; col <= N; col++) {
        if (matrix[row - 1][col - 1] == '*') {
          continue;
        }
        dp[row][col] = (dp[row - 1][col] + dp[row][col - 1] + dp[row][col]) % MOD;
      }
    }

    System.out.println(dp[N][N]);
    sc.close();
  }
}
