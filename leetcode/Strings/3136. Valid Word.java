class Solution {
  public boolean isValid(String word) {
    int N = word.length();
    if (N < 3) {
      return false;
    }
    boolean vowelFlag = false;
    boolean consonentsFlag = false;
    for (int pointer = 0; pointer < N; pointer++) {
      char ch = Character.toLowerCase(word.charAt(pointer));
      if (ch >= 'a' && ch <= 'z' || (ch >= '0' && ch <= '9')) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
          vowelFlag = true;
        } else if (ch >= 'a' && ch <= 'z') {
          consonentsFlag = true;
        }
      } else {
        return false;
      }
    }
    return vowelFlag && consonentsFlag;
  }
}