class Solution {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    Queue<List<String>> queue = new LinkedList<>();
    queue.add(new ArrayList<>(Arrays.asList(beginWord)));
    Set<String> dic = new HashSet<>(wordList);
    dic.remove(beginWord);
    boolean isAnswerFound = false;
    List<List<String>> result = new ArrayList<>();
    List<String> levelString = new ArrayList<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        List<String> curr = queue.poll();
        char lastString[] = curr.get(curr.size() - 1).toCharArray();
        if (curr.get(curr.size() - 1).equals(endWord)) {
          isAnswerFound = true;
          result.add(curr);
        }
        for (int index = 0; index < lastString.length; index++) {
          char originalChar = lastString[index];
          for (int c = 0; c < 26; c++) {
            char ch = (char) ('a' + c);
            if (originalChar == ch) {
              continue;
            }
            lastString[index] = ch;
            String currString = new String(lastString);
            if (dic.contains(currString)) {
              levelString.add(currString);
              curr.add(currString);
              queue.offer(new ArrayList<>(curr));
              curr.remove(curr.size() - 1);
            }
          }
          lastString[index] = originalChar;
        }
      }
      for (String str : levelString) {
        dic.remove(str);
      }
      if (isAnswerFound) {
        return result;
      }
    }
    return result;
  }
}