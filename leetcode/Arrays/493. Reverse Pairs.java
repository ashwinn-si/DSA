class Solution {
  int count;

  void merge(int arr[], int left, int right, int mid) {
    int N1 = mid - left + 1;
    int N2 = right - mid;

    int tempL[] = new int[N1];
    int tempR[] = new int[N2];

    for (int i = 0; i < N1; i++) {
      tempL[i] = arr[left + i];
    }
    for (int i = 0; i < N2; i++) {
      tempR[i] = arr[mid + i + 1];
    }

    int K = left;
    int p1 = 0;
    int p2 = 0;
    while (p1 < N1 && p2 < N2) {
      if (tempL[p1] < tempR[p2]) {
        arr[K++] = tempL[p1++];
      } else {
        arr[K++] = tempR[p2++];
      }
    }

    while (p1 < N1) {
      arr[K++] = tempL[p1++];
    }

    while (p2 < N2) {
      arr[K++] = tempR[p2++];
    }
  }

  void checker(int nums[], int left, int right, int mid) {
    int p1 = left;
    int p2 = mid + 1;
    while (p1 < mid + 1) {
      while (p2 < right + 1 && (long) nums[p1] > nums[p2] * 2L) {
        p2++;
      }
      count += (p2 - (mid + 1));
      p1++;
    }
  }

  void divide(int arr[], int left, int right) {
    if (left < right) {
      int mid = left + (right - left) / 2;

      divide(arr, left, mid);

      divide(arr, mid + 1, right);

      checker(arr, left, right, mid);

      merge(arr, left, right, mid);
    }
  }

  public int reversePairs(int[] arr) {
    count = 0;
    divide(arr, 0, arr.length - 1);
    return count;
  }
}