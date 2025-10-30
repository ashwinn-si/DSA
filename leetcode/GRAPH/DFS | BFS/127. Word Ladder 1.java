class Solution {
  public int ladderLength(String begin, String end, List<String> words) {
    int count = 0;
    Queue<StringBuffer> queue = new LinkedList<>();
    Set<String> dic = new HashSet<>(words);
    queue.offer(new StringBuffer(begin));
    while (!queue.isEmpty()) {
      int size = queue.size();
      boolean flag = false;
      for (int e = 0; e < size; e++) {
        StringBuffer curr = queue.poll();
        if (curr.toString().equals(end)) {
          return count + 1;
        }
        int N = curr.length();
        for (int index = 0; index < N; index++) {
          char deleteChar = curr.charAt(index);
          curr.deleteCharAt(index);
          for (int c = 0; c < 26; c++) {
            char ch = (char) ('a' + c);
            if (ch == deleteChar) {
              continue;
            }
            curr.insert(index, ch);
            if (dic.contains(curr.toString())) {
              dic.remove(curr.toString());
              queue.offer(new StringBuffer(curr));
              flag = true;
            }
            curr.deleteCharAt(index);
          }
          curr.insert(index, deleteChar);
        }
      }
      if (flag)
        count++;
    }
    return 0;
  }
}