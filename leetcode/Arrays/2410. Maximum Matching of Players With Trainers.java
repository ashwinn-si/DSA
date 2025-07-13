class Solution {
  public int matchPlayersAndTrainers(int[] players, int[] trainers) {
    Arrays.sort(players);
    Arrays.sort(trainers);
    int pointer1 = 0;
    int pointer2 = 0;
    int N = players.length;
    int M = trainers.length;
    while (pointer1 < N && pointer2 < M) {
      if (players[pointer1] <= trainers[pointer2]) {
        pointer1++;
        pointer2++;
      } else {
        pointer2++;
      }
    }
    return pointer1;
  }
}