class Solution {
  void helper(int resultIndex, int result[], ArrayList<Element> arr, HashMap<Integer, Element> hash, int x,
      int runningSum) {
    Collections.sort(arr, (a, b) -> a.occ == b.occ ? b.number - a.number : b.occ - a.occ);
    int res = 0;
    for (int index = 0; index < arr.size() && index < x; index++) {
      res += (arr.get(index).occ * arr.get(index).number);
    }
    result[resultIndex++] = res;
  }

  public int[] findXSum(int[] nums, int k, int x) {
    ArrayList<Element> arr = new ArrayList<>();
    HashMap<Integer, Element> hash = new HashMap<>();
    int runningSum = 0;
    for (int index = 0; index < k; index++) {
      if (hash.get(nums[index]) == null) {
        Element obj = new Element(nums[index]);
        hash.put(nums[index], obj);
        arr.add(obj);
      }
      hash.get(nums[index]).occ++;
      runningSum += nums[index];
    }
    int result[] = new int[nums.length - k + 1];
    int resultIndex = 0;
    helper(resultIndex, result, arr, hash, x, runningSum);
    resultIndex++;
    for (int index = 0; index < nums.length - k; index++) {
      hash.get(nums[index]).occ--;
      if (hash.get(nums[index + k]) == null) {
        hash.put(nums[index + k], new Element(nums[index + k]));
        arr.add(hash.get(nums[index + k]));
      }
      hash.get(nums[index + k]).occ++;
      runningSum += nums[index + k];
      runningSum -= nums[index];
      helper(resultIndex, result, arr, hash, x, runningSum);
      resultIndex++;
    }
    return result;
  }
}

class Element {
  int number, occ;

  Element(int number) {
    this.number = number;
    this.occ = 0;
  }
}