import java.util.*;

public class Main {
  static long lookUp(long segment[], int currNode, int nodeStart, int nodeEnd, int queryStart, int queryEnd) {
    if (nodeStart > queryEnd || nodeEnd < queryStart) {
      return 0L;
    }

    if (nodeStart >= queryStart && nodeEnd <= queryEnd) {
      return segment[currNode];
    }
    int mid = (nodeEnd + nodeStart) / 2;
    return lookUp(segment, currNode * 2, nodeStart, mid, queryStart, queryEnd)
        + lookUp(segment, currNode * 2 + 1, mid + 1, nodeEnd, queryStart, queryEnd);
  }

  static void update(long segment[], int currNode, int nodeStart, int nodeEnd, int queryStart, int queryEnd,
      int changeValue) {
    if (nodeStart > queryEnd || nodeEnd < queryStart) {
      return;
    }

    if (nodeStart >= queryStart && nodeEnd <= queryEnd) {
      segment[currNode] = changeValue;
      return;
    }
    int mid = (nodeStart + nodeEnd) / 2;
    update(segment, currNode * 2, nodeStart, mid, queryStart, queryEnd, changeValue);
    update(segment, currNode * 2 + 1, mid + 1, nodeEnd, queryStart, queryEnd, changeValue);
    segment[currNode] = segment[currNode * 2] + segment[currNode * 2 + 1];
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int Q = sc.nextInt();
    int N = 1;
    while (N < size)
      N <<= 1;

    long segementArray[] = new long[2 * N];

    for (int i = 0; i < size; i++) {
      segementArray[N + i] = sc.nextInt();
    }

    for (int i = N - 1; i >= 1; i--) {
      segementArray[i] = segementArray[2 * i] + segementArray[2 * i + 1];
    }

    for (int q = 0; q < Q; q++) {
      int qType = sc.nextInt();
      if (qType == 1) {
        // update
        int index = sc.nextInt();
        int value = sc.nextInt();
        update(segementArray, 1, 0, N - 1, index - 1, index - 1, value);
      } else {
        // query
        System.out.println(lookUp(segementArray, 1, 0, N - 1, sc.nextInt() - 1, sc.nextInt() - 1));
      }
    }

    sc.close();
  }

}