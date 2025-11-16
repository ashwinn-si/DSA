class Solution {
  public int countBinarySubstrings(String s) {
    ArrayList<Integer> seq = new ArrayList<>();
    int leftPointer = 0;
    int n = s.length();
    while (leftPointer < n) {
      int rightPointer = leftPointer;
      while (rightPointer < n && s.charAt(leftPointer) == s.charAt(rightPointer)) {
        rightPointer++;
      }
      seq.add(rightPointer - leftPointer);
      leftPointer = rightPointer;
    }
    int result = 0;
    for (int index = 1; index < seq.size(); index++) {
      result += Math.min(seq.get(index), seq.get(index - 1));
    }
    return result;
  }
}