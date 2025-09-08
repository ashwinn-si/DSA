class Solution {
    public int kDistinctChar(String S, int K) {
        //your code goes here
        HashMap<Character, Integer> hash = new HashMap<>();
    int leftPointer = 0;
    int max = 0;
    int N = S.length();
    for (int i = 0; i < N; i++) {
      char ch = S.charAt(i);
      if (hash.get(ch) != null) {
        hash.put(ch, i);
      } else {
        if (hash.size() == K) {
          char removeKey = 'a';
          int removeIndex = Integer.MAX_VALUE;
          for (char key : hash.keySet()) {
            if (removeIndex >= hash.get(key)) {
              removeIndex = hash.get(key);
              removeKey = key;
            }
          }
          leftPointer = removeIndex + 1;
          hash.remove(removeKey);
        }
        hash.put(ch, i);
      }
      max = Math.max(max, i - leftPointer + 1);
    }
    return max;
    }
}