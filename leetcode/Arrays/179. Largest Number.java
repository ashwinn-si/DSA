class Solution {
  public String largestNumber(int[] nums) {
    int N = nums.length;
    Integer[] numBox = new Integer[N];

    for (int i = 0; i < N; i++) {
      numBox[i] = nums[i];
    }

    Arrays.sort(numBox, (a, b) -> (String.format("%d%d", b, a)).compareTo(String.format("%d%d", a, b)));

    if (numBox[0] == 0)
      return "0";

    StringBuilder str = new StringBuilder();
    for (Integer num : numBox) {
      str.append(num);
    }

    return str.toString();
  }
}
