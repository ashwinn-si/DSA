class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> hash = new HashMap<>();
    for (String str : strs) {
      char alpha[] = str.toCharArray();
      Arrays.sort(alpha);
      String key = new String(alpha);
      hash.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }
    List<List<String>> result = new ArrayList<>();
    for (String key : hash.keySet()) {
      result.add(hash.get(key));
    }
    return result;
  }
}