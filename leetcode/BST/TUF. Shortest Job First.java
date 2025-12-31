class Solution {
  public long solve(int[] bt) {
    // your code goes here
    Arrays.sort(bt);
    long waitingTime = 0L;
    long currTime = 0L;
    for (int t : bt) {
      currTime += t;
      waitingTime += (currTime - t);
    }
    return (long) Math.floor(waitingTime / bt.length);
  }
}