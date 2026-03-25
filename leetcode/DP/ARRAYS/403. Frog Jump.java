class Solution {
  public boolean canCross(int[] stones) {

    HashMap<Integer, Set<Integer>> dp = new HashMap<>();

    for (int stone : stones) {
      dp.put(stone, new HashSet<>());
    }

    dp.get(0).add(0);

    for (int stone : stones) {

      for (int jump : dp.get(stone)) {

        for (int step = -1; step <= 1; step++) {

          int newJump = jump + step;

          if (newJump <= 0)
            continue;

          int newStone = stone + newJump;

          if (dp.containsKey(newStone)) {
            dp.get(newStone).add(newJump);
          }
        }
      }
    }

    return !dp.get(stones[stones.length - 1]).isEmpty();
  }
}