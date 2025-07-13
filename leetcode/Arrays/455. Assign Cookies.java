class Solution {
  public int findContentChildren(int[] arr1, int[] arr2) {
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    int pointer1 = 0, pointer2 = 0, N = arr1.length, M = arr2.length;
    while (pointer1 < N && pointer2 < M) {
      if (arr1[pointer1] <= arr2[pointer2]) {
        pointer1++;
        pointer2++;
      } else {
        pointer2++;
      }
    }
    return pointer1;
  }
}