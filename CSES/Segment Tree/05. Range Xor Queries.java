import java.util.*;

public class Main {
  static int lookup(int segment[], int currIndex, int nodeStart, int nodeEnd, int queryStart, int queryEnd) {
    if (queryStart > nodeEnd || queryEnd < nodeStart) {
      return 0;
    }

    if (nodeStart >= queryStart && nodeEnd <= queryEnd) {
      return segment[currIndex];
    }

    int mid = (nodeStart + nodeEnd) / 2;
    return lookup(segment, currIndex * 2, nodeStart, mid, queryStart, queryEnd)
        ^ lookup(segment, currIndex * 2 + 1, mid + 1, nodeEnd, queryStart, queryEnd);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int Q = sc.nextInt();
    int length = 0;
    while (1 << length < N)
      length++;

    length = 1 << length;
    sc.nextLine();
    int segmentArray[] = new int[2 * length + 1];

    for (int index = 0; index < N; index++) {
      segmentArray[index + length] = sc.nextInt();
    }

    for (int index = length - 1; index >= 1; index--) {
      segmentArray[index] = segmentArray[index * 2] ^ segmentArray[2 * index + 1];
    }

    for (int index = 0; index < Q; index++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      System.out.println(lookup(segmentArray, 1, 1, length, start, end));
    }
    sc.close();
  }
}