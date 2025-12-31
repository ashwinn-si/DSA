class Solution {
  public int findPlatform(int[] Arrival, int[] Departure) {
    // your code goes here
    Arrays.sort(Arrival);
    Arrays.sort(Departure);
    int n = Arrival.length;
    int pointerA = 1;
    int pointerD = 0;
    int count = 1;
    int ans = 1;
    while (pointerA < n && pointerD < n) {
      if (Arrival[pointerA] <= Departure[pointerD]) {
        count++;
        pointerA++;
      } else {
        count--;
        pointerD++;
      }
      ans = Math.max(ans, count);
    }

    return ans;
  }
}