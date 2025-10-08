import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] nums = new int[N];
    for (int i = 0; i < N; i++)
      nums[i] = sc.nextInt();

    int logArr[] = new int[N + 1];
    logArr[1] = 1;
    for (int index = 2; index <= N; index++) {
      logArr[index] = logArr[index / 2] + 1;
    }

    int K = logArr[N];

    int[][] matrix = new int[K][N];

    for (int i = 0; i < N; i++)
      matrix[0][i] = nums[i];

    for (int k = 1; k < K; k++) {
      int len = 1 << k;
      int half = 1 << (k - 1);
      for (int i = 0; i + len <= N; i++) {
        matrix[k][i] = Math.min(matrix[k - 1][i], matrix[k - 1][i + half]);
      }
    }

    for (int q = 0; q < Q; q++) {
      int start = sc.nextInt() - 1;
      int end = sc.nextInt() - 1;

      int level = logArr[end - start + 1] - 1;

      System.out.println(Math.min(matrix[level][start], matrix[level][end + 1 - (1 << (level))]));

    }
    sc.close();
  }

}