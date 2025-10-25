class Solution {
  public int totalMoney(int n) {
    int result = 0;
    int mondayAmount = 1;
    for (int index = 0; index < n / 7; index++) {
      for (int i = 0; i < 7; i++) {
        result += mondayAmount + i;
      }
      mondayAmount++;
    }
    for (int index = 0; index < n % 7; index++) {
      result += mondayAmount + index;
    }
    return result;
  }
}