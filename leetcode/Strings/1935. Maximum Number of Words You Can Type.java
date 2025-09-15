class Solution {
  public int canBeTypedWords(String text, String brokenLetters) {
    boolean freq[] = new boolean[26];
    for (char ch : brokenLetters.toCharArray()) {
      freq[ch - 'a'] = true;
    }
    int count = 0;
    for (String str : text.split(" ")) {
      boolean flag = true;
      for (char ch : str.toCharArray()) {
        if (freq[ch - 'a'] == true) {
          flag = false;
          break;
        }
      }
      if (flag) {
        count++;
      }
    }
    return count;
  }
}