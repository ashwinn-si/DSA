class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int pointer1 = 0, pointer2 = 0, N = nums1.length, M = nums2.length;
    int e1 = 0, e2 = 0, currElement = 0, mid1 = (N + M) / 2, mid2 = mid1 - 1;
    while (pointer1 < N && pointer2 < M) {
      if (nums1[pointer1] < nums2[pointer2]) {
        if (currElement == mid1) {
          e1 = nums1[pointer1];
        }
        if (currElement == mid2) {
          e2 = nums1[pointer1];
        }
        pointer1++;
      } else {
        if (currElement == mid1) {
          e1 = nums2[pointer2];
        }
        if (currElement == mid2) {
          e2 = nums2[pointer2];
        }
        pointer2++;
      }
      currElement++;
    }
    while (pointer1 < N) {
      if (currElement == mid1) {
        e1 = nums1[pointer1];
      }
      if (currElement == mid2) {
        e2 = nums1[pointer1];
      }
      currElement++;
      pointer1++;
    }
    while (pointer2 < M) {
      if (currElement == mid1) {
        e1 = nums2[pointer2];
      }
      if (currElement == mid2) {
        e2 = nums2[pointer2];
      }
      currElement++;
      pointer2++;
    }
    if ((N + M) % 2 == 1) {
      return e1 / 1.0;
    } else {
      return (e1 + e2) / 2.0;
    }
  }
}