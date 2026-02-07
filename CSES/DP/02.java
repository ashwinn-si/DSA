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
    int target = sc.nextInt();
    int nums[] = new int[N];
    for (int index = 0; index < N; index++) {
      nums[index] = sc.nextInt();
    }
    Arrays.sort(nums);

    if (nums[0] > target) {
      System.out.println("-1");
      return;
    }

    int dp[] = new int[target + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int index = 0; index < N; index++) {
      int num = nums[index];
      for (int k = 1; k <= target; k++) {
        if (num <= k && dp[k - num] != Integer.MAX_VALUE) {
          dp[k] = Math.min(dp[k], 1 + dp[k - num]);
        }
      }
    }

    System.out.println(dp[target] == Integer.MAX_VALUE ? -1 : dp[target]);
    sc.close();
  }
}