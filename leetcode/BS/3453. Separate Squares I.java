class Solution {
  double calculateArea(double x, double y) {
    return x * y;
  }

  double[] find(int[][] sq, double mid) {
    double left = 0D;
    double right = 0D;
    for (int square[] : sq) {
      int sY = square[1];
      int eY = square[1] + square[2];
      int l = square[2];
      if (eY <= mid) {
        left += calculateArea(l, l);
      } else if (sY >= mid) {
        right += calculateArea(l, l);
      } else {
        left += calculateArea(l, mid - sY);
        right += calculateArea(l, eY - mid);
      }
    }
    return new double[] { left, right };
  }

  public double separateSquares(int[][] sq) {
    int n = sq.length;
    double start = Double.MAX_VALUE;
    double end = 0;
    for (int[] s : sq) {
      start = Math.min(start, s[1]);
      end = Math.max(end, s[1] + s[2]);
    }
    while (end - start > 1e-6) {
      double mid = (start + end) / 2.0;
      double area[] = find(sq, mid);
      // left area >= right area
      if (area[0] >= area[1]) {
        end = mid;
      } else {
        start = mid;
      }
    }
    return start;
  }
}