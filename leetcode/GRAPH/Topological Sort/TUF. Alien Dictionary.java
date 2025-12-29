class Solution {
  void handlePair(String str1, String str2, List<List<Integer>> adj, int inDegree[]) {
    int pointer1 = 0, pointer2 = 0;
    int n = str1.length(), m = str2.length();
    while (pointer1 < n && pointer2 < m) {
      if (str1.charAt(pointer1) == str2.charAt(pointer2)) {
        pointer1++;
        pointer2++;
        continue;
      }
      int ch1 = str1.charAt(pointer1) - 'a';
      int ch2 = str2.charAt(pointer2) - 'a';
      adj.get(ch1).add(ch2);
      inDegree[ch2]++;
      break;
    }
  }

  public String findOrder(String[] dict, int N, int K) {
    List<List<Integer>> adj = new ArrayList<>();
    int inDegree[] = new int[K];
    for (int index = 0; index < K; index++) {
      adj.add(new ArrayList<>());
    }
    for (int index = 0; index < N - 1; index++) {
      handlePair(dict[index], dict[index + 1], adj, inDegree);
    }
    StringBuffer str = new StringBuffer();
    Queue<Integer> queue = new LinkedList<>();
    for (int index = 0; index < K; index++) {
      if (inDegree[index] == 0) {
        queue.offer(index);
      }
    }
    while (!queue.isEmpty()) {
      int index = queue.poll();
      str.append((char) (index + 'a'));
      str.append(" ");
      for (int adjNode : adj.get(index)) {
        inDegree[adjNode]--;
        if (inDegree[adjNode] == 0) {
          queue.offer(adjNode);
        }
      }
    }
    return str.toString();
  }
}