import java.util.*;

public class Main {

  static int lookUp(int segmentArray[], int currIndex, int checkValue, int nodeStart, int nodeEnd) {
    if (nodeStart == nodeEnd) {
      if (segmentArray[currIndex] >= checkValue) {
        // we can allocate a room
        segmentArray[currIndex] -= checkValue;
        return currIndex;
      } else {
        // we cant allocate a room
        return -1;
      }
    }

    int mid = (nodeStart + nodeEnd) / 2;
    // checking if we can allocate in left node
    int res1 = -1;
    int res2 = -1;
    if (segmentArray[currIndex * 2] >= checkValue) {
      res1 = lookUp(segmentArray, currIndex * 2, checkValue, nodeStart, mid);
    }
    if (res1 != -1) {
      segmentArray[currIndex] = Math.max(segmentArray[currIndex * 2], segmentArray[currIndex * 2 + 1]);
      return res1;
    }
    if (segmentArray[currIndex * 2 + 1] >= checkValue) {
      res2 = lookUp(segmentArray, currIndex * 2 + 1, checkValue, mid + 1, nodeEnd);
    }
    if (res2 != -1) {
      segmentArray[currIndex] = Math.max(segmentArray[currIndex * 2], segmentArray[currIndex * 2 + 1]);
      return res2;
    }
    return -1;
  }

  static int getPow(int N) {
    int result = 0;
    while ((1 << result) < N) {
      result++;
    }
    return 1 << result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int Q = sc.nextInt();

    int length = getPow(N);
    int segmentArray[] = new int[2 * length + 1];

    for (int index = 0; index < N; index++) {
      segmentArray[index + length] = sc.nextInt();
    }

    for (int index = length - 1; index >= 0; index--) {
      segmentArray[index] = Math.max(segmentArray[index * 2], segmentArray[index * 2 + 1]);
    }

    for (int i = 0; i < Q; i++) {
      int result = lookUp(segmentArray, 1, sc.nextInt(), 1, length);
      if (result == -1) {
        System.out.print(0 + " ");
      } else {
        System.out.print(result - length + 1 + " ");
      }
    }
    sc.close();
  }
}