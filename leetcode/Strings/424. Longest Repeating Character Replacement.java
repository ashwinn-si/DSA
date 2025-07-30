class Solution {
  public int characterReplacement(String s, int K) {
    int freq[] = new int[26];

    for (char ch : s.toCharArray()) {
      freq[ch - 'A']++;
    }

    int result = 0;
    int N = s.length();
    for (int i = 0; i < 26; i++) {
      if (freq[i] == 0)
        continue;
      int currCount = 0;
      char compareChar = (char) ('A' + i);
      int convertCount = 0;
      int leftPointer = 0;
      for (int rightPointer = 0; rightPointer < N; rightPointer++) {
        if (s.charAt(rightPointer) != compareChar) {
          convertCount++;
        }
        while (leftPointer <= rightPointer && convertCount > K) {
          if (compareChar != s.charAt(leftPointer)) {
            convertCount--;
          }
          leftPointer++;
        }
        result = Math.max(result, rightPointer - leftPointer + 1);
      }
    }
    return result;
  }
}