class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int targetRow = -1;
    int left = 0, right = matrix.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (matrix[mid][0] <= target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    targetRow = right;

    if (targetRow < 0) {
      return false;
    }

    left = 0;
    right = matrix[0].length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (matrix[targetRow][mid] == target) {
        return true;
      }
      if (matrix[targetRow][mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }
}
