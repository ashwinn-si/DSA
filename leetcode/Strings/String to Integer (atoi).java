class Solution {
  public int myAtoi(String s) {
    int pointer = 0;
    int N = s.length();
    long result = 0;
    boolean negFlag = false;
    boolean posFlag = false;
    // skipping the white spaces
    while (pointer < N && s.charAt(pointer) == ' ') {
      pointer++;
    }
    // checking for the sign
    while (pointer < N && (s.charAt(pointer) == '+' || s.charAt(pointer) == '-')) {
      if (negFlag || posFlag) {
        return 0;
      }
      if (s.charAt(pointer) == '-') {
        negFlag = true;
      } else {
        posFlag = true;
      }
      pointer++;
    }

    while (pointer < N) {
      char ch = s.charAt(pointer);
      if (!(ch >= '0' && ch <= '9')) {
        break;
      }
      if (ch == '0' && result == 0) {
        pointer++;
        continue;
      }
      result = (result * 10) + (ch - '0');
      pointer++;
      if (!negFlag && result > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
      if (negFlag && -result < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
    }
    if (negFlag)
      result *= -1;
    return (int) result;
  }
}