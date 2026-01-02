class Solution {
  boolean canConsider(char ch) {
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z' || (ch >= '0' && ch <= '9'));
  }

  public boolean isPalindrome(String s) {
    int pointer1 = 0;
    int pointer2 = s.length() - 1;
    while (pointer1 < pointer2) {
      if (!canConsider(s.charAt(pointer1))) {
        pointer1++;
        continue;
      }
      if (!canConsider(s.charAt(pointer2))) {
        pointer2--;
        continue;
      }
      if (Character.toLowerCase(s.charAt(pointer1)) != Character.toLowerCase(s.charAt(pointer2))) {
        return false;
      }
      pointer1++;
      pointer2--;
    }
    return true;
  }
}