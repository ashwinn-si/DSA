class Solution {
  public int countCollisions(String dir) {
    int pointerLeft = 0;
    int pointerRight = dir.length() - 1;
    while (pointerLeft < dir.length() && dir.charAt(pointerLeft) == 'L') {
      pointerLeft++;
    }
    while (pointerRight > -1 && dir.charAt(pointerRight) == 'R') {
      pointerRight--;
    }
    int res = 0;
    while (pointerLeft <= pointerRight) {
      if (dir.charAt(pointerLeft) == 'L' || dir.charAt(pointerLeft) == 'R') {
        res++;
      }
      pointerLeft++;
    }

    return res;
  }
}