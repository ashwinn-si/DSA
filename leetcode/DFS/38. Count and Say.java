class Solution {
  public String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }
    String prevResult = countAndSay(n - 1);
    StringBuffer result = new StringBuffer();
    int pointer = 0;
    int length = prevResult.length();
    while (pointer < length) {
      char currNumber = prevResult.charAt(pointer);
      int tempPointer = pointer + 1;
      while (tempPointer < length && prevResult.charAt(tempPointer) == currNumber) {
        tempPointer++;
      }
      result.append((tempPointer - pointer));
      result.append(currNumber);
      pointer = tempPointer;
    }
    return result.toString();
  }
}