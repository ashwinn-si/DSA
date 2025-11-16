class Solution {
  public int numSub(String s) {
    long result = 0;
    int MOD = 1_000_000_007;
    int pointer = 0;
    int length = s.length();

    while (pointer < length) {
      if (s.charAt(pointer) == '1') {
        long oneLength = 0;

        while (pointer < length && s.charAt(pointer) == '1') {
          pointer++;
          oneLength++;
        }

        long count = oneLength * (oneLength + 1) / 2;
        result = (result + count) % MOD;

      } else {
        pointer++;
      }
    }

    return (int) (result % MOD);
  }
}
