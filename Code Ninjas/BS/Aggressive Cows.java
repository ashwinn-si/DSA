import java.util.*;

public class Solution {
  static boolean checker(int[] nums, int space, int K) {
    int prevLimit = nums[0] + space;
    K--;
    for (int num : nums) {
      if (num >= prevLimit) {
        K--;
        prevLimit = num + space;
      }
      if (K == 0) {
        return true;
      }
    }
    return K == 0;
  }

  public static int aggressiveCows(int[] stalls, int K) {
    // Write your code here.
    Arrays.sort(stalls);
    int len = stalls.length;
    int left = 1;
    int right = stalls[len - 1] - stalls[0];
    while (left <= right) {
      int mid = (left + right) / 2;
      if (checker(stalls, mid, K)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return right;
  }
}