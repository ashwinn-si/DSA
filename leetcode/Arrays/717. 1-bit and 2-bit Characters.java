class Solution {
  boolean helper(int index, int bits[]) {
    if (index == -1) {
      return true;
    }
    if (index < 0) {
      return false;
    }
    boolean result = false;
    if (bits[index] == 0) {
      result |= helper(index - 1, bits);
      if (index - 1 >= 0 && bits[index - 1] == 1) {
        result |= helper(index - 2, bits);
      }
    }
    if (bits[index] == 1) {
      if (index - 1 < 0 || bits[index - 1] != 1) {
        return false;
      }
      result |= helper(index - 2, bits);
    }
    return result;

  }

  public boolean isOneBitCharacter(int[] bits) {
    return helper(bits.length - 2, bits);
  }
}