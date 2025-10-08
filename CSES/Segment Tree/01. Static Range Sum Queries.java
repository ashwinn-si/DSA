import java.util.*;

public class Main {
  static int lookup(int seg[], int curr, int ns, int ne, int qs, int qe) {
    if (ns > qe || ne < qs)
      return 0;
    if (ns >= qs && ne <= qe)
      return seg[curr];

    int mid = (ns + ne) / 2;

    int leftAns = lookup(seg, 2 * curr, ns, mid, qs, qe);
    int rightAns = lookup(seg, 2 * curr + 1, mid + 1, ne, qs, qe);

    return leftAns + rightAns;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int Q = sc.nextInt();
    int N = 1;
    while (N < size)
      N <<= 1;

    int segementArray[] = new int[2 * N];

    for (int i = 0; i < size; i++) {
      segementArray[N + i] = sc.nextInt();
    }

    for (int i = N - 1; i >= 1; i--) {
      segementArray[i] = segementArray[i + i + 1] + segementArray[i + i];
    }

    for (int q = 0; q < Q; q++) {
      System.out.println(lookup(segementArray, 1, 0, N - 1, sc.nextInt() - 1,
          sc.nextInt() - 1));
    }

    sc.close();
  }
}