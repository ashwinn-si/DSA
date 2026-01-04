class Solution {
  int[] getDivisorCount(int num) {
    int count = 0;
    int sum = 0;
    HashSet<Integer> set = new HashSet<>();
    for (int index = 1; index <= (int) (Math.sqrt(num)); index++) {
      if (num % index == 0) {
        set.add(index);
        set.add(num / index);
      }
    }
    if (set.size() == 4) {
      for (int a : new ArrayList<>(set)) {
        count++;
        sum += a;
      }
    }
    return new int[] { count, sum };
  }

  public int sumFourDivisors(int[] nums) {
    int result = 0;
    for (int num : nums) {
      int curr[] = getDivisorCount(num);
      if (curr[0] == 4) {

        result += curr[1];
      }
    }
    return result;
  }
}