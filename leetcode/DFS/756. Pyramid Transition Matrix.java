class Solution {
  boolean dfs(String bottom, int index, StringBuffer newBottom, HashMap<String, List<String>> hash) {
    if (bottom.length() == 2) {
      return hash.get(bottom) != null;
    }
    int len = bottom.length();
    if (index == len - 1) {
      if (dfs(newBottom.toString(), 0, new StringBuffer(), hash)) {
        return true;
      }
      return false;
    }
    if (hash.get(bottom.substring(index, index + 2)) == null) {
      return false;
    }
    for (String pair : hash.get(bottom.substring(index, index + 2))) {
      newBottom.append(pair.charAt(2));
      if (dfs(bottom, index + 1, newBottom, hash)) {
        return true;
      }
      newBottom.deleteCharAt(newBottom.length() - 1);
    }
    return false;
  }

  public boolean pyramidTransition(String bottom, List<String> allowed) {
    HashMap<String, List<String>> hash = new HashMap<>();
    for (String str : allowed) {
      hash.computeIfAbsent(str.substring(0, 2), (k) -> new ArrayList<>()).add(str);
    }
    return dfs(bottom, 0, new StringBuffer(), hash);
  }
}