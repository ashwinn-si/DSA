class Solution {
  public int maxBottlesDrunk(int numBottles, int numExchange) {
    int result = 0;
    while (numBottles >= numExchange) {
      result += numExchange;
      numBottles = numBottles - numExchange + 1;
      numExchange++;
    }
    return result + numBottles;
  }
}