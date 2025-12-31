class Solution {
  public int[] JobScheduling(int[][] Jobs) {

    // Sort jobs by profit (descending)
    Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

    // Find max deadline
    int maxDeadline = 0;
    for (int[] job : Jobs) {
      maxDeadline = Math.max(maxDeadline, job[1]);
    }

    boolean[] slot = new boolean[maxDeadline + 1];

    int jobsDone = 0;
    int maxProfit = 0;

    for (int[] job : Jobs) {
      // Try to find a free slot from deadline backwards
      for (int t = job[1]; t > 0; t--) {
        if (!slot[t]) {
          slot[t] = true;
          jobsDone++;
          maxProfit += job[2];
          break;
        }
      }
    }

    return new int[] { jobsDone, maxProfit };
  }
}
