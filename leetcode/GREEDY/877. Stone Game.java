class Solution {
 public boolean stoneGame(int[] piles) {
    int a = 0;
    int b = 0;
    for (int i = 0; i < piles.length - 1; i ++){
      a = Math.max(a + piles[i], a + piles[i + 1]);
      b = piles[i] < piles[i+1] ? b+ piles[i] : b + piles[i+1];
    }
    return a > b;
  }
}