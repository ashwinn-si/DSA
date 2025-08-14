class Solution {
  public int totalFruit(int[] nums) {
    HashMap<Integer, Integer> hash = new HashMap<>();
    int leftPointer = 0;
    int result = 0;
    int N = nums.length;
    for (int rightPointer = 0; rightPointer < N; rightPointer++) {
      int num = nums[rightPointer];
      if (hash.get(num) != null) {
        hash.put(num, rightPointer);
      } else {
        if (hash.keySet().size() == 2) {
          // taking the lesser element
          int removeKey = Integer.MAX_VALUE;
          int removeValue = Integer.MAX_VALUE;
          for (int hashKey : hash.keySet()) {
            if (removeValue > hash.get(hashKey)) {
              removeValue = hash.get(hashKey);
              removeKey = hashKey;
            }
          }
          leftPointer = hash.get(removeKey) + 1;
          hash.remove(removeKey);
        }
        hash.put(num, rightPointer);
      }
      result = Math.max(result, rightPointer - leftPointer + 1);
    }
    return result;
  }
}