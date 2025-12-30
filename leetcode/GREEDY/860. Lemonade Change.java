class Solution {

  private int getIndex(int bill) {
    if (bill == 5)
      return 0;
    if (bill == 10)
      return 1;
    return 2;
  }

  public boolean lemonadeChange(int[] bills) {
    int[] freq = new int[3];

    for (int bill : bills) {
      int idx = getIndex(bill);

      if (bill == 5) {
        freq[idx]++;
      } else if (bill == 10) {
        if (freq[getIndex(5)] == 0)
          return false;
        freq[getIndex(5)]--;
        freq[idx]++;
      } else {
        if (freq[getIndex(10)] > 0 && freq[getIndex(5)] > 0) {
          freq[getIndex(10)]--;
          freq[getIndex(5)]--;
        } else if (freq[getIndex(5)] >= 3) {
          freq[getIndex(5)] -= 3;
        } else {
          return false;
        }
        freq[idx]++;
      }
    }
    return true;
  }
}
