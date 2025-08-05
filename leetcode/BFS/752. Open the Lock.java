class Solution {

  String subDigit(String s, int index) {
    char[] chars = s.toCharArray();
    chars[index] = (char) ((chars[index] - '0' + 9) % 10 + '0');
    return new String(chars);
  }

  String addDigit(String s, int index) {
    char[] chars = s.toCharArray();
    chars[index] = (char) ((chars[index] - '0' + 1) % 10 + '0');
    return new String(chars);
  }

  public int openLock(String[] deadend, String target) {
    Set<String> deadends = new HashSet<>(Arrays.asList(deadend));
    if (deadends.contains("0000"))
      return -1;
    if (target.equals("0000"))
      return 0;

    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();

    queue.offer("0000");
    visited.add("0000");

    int steps = 0;

    while (!queue.isEmpty()) {
      int size = queue.size(); // Level size
      for (int i = 0; i < size; i++) {
        String curr = queue.poll();

        if (curr.equals(target))
          return steps;
        if (deadends.contains(curr))
          continue;

        for (int j = 0; j < 4; j++) {
          String up = addDigit(curr, j);
          String down = subDigit(curr, j);

          if (!visited.contains(up) && !deadends.contains(up)) {
            queue.offer(up);
            visited.add(up);
          }

          if (!visited.contains(down) && !deadends.contains(down)) {
            queue.offer(down);
            visited.add(down);
          }
        }
      }
      steps++;
    }

    return -1;
  }
}
