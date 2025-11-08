class Solution {
  public int longestStrChain(String[] words) {
    Arrays.sort(words, Comparator.comparingInt(String::length));
    HashMap<String, Integer> hash = new HashMap<>();
    int maxi = 0;
    for (String word : words) {
      int ans = 1;
      StringBuffer cpy = new StringBuffer(word);
      for (int index = 0; index < word.length(); index++) {
        char ch = cpy.charAt(index);

        cpy.deleteCharAt(index);
        Integer count = hash.get(cpy.toString());
        if (count != null) {
          ans = Math.max(ans, count + 1);
        }
        cpy.insert(index, ch);
      }
      hash.put(word, ans);
      maxi = Math.max(maxi, ans);
    }
    return maxi;
  }
}