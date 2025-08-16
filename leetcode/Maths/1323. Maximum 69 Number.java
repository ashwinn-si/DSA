class Solution {
  public int maximum69Number(int num) {
    int len = (int) (Math.log10(num) + 1);
    for (int i = len - 1; i >= 0; i--) {
      int digit = (num / (int) (Math.pow(10, i))) % 10;
      if (digit == 6) {
        return (int) (num + ((Math.pow(10, i) * 3)));
      }
    }
    return num;
  }
}