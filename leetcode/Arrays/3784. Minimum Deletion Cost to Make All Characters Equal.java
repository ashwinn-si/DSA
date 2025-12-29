class Solution {
  public long minCost(String s, int[] cost) {
    HashMap<Character, Long> hash = new HashMap<>();
    long totalCost = 0L;
    int n = cost.length;
    for (int index = 0; index < n; index++) {
      hash.put(s.charAt(index), hash.getOrDefault(s.charAt(index), 0L) + cost[index]);
      totalCost += cost[index];
    }
    long result = Long.MAX_VALUE;
    for (char ch : hash.keySet()) {
      long removalCost = totalCost - hash.get(ch);
      result = Math.min(result, removalCost);
    }
    return result;
  }
}