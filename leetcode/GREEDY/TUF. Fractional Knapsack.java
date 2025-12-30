class Solution {
  public double fractionalKnapsack(int[] val, int[] wt, long cap) {
    // Your code goes here
    List<Element> arr = new ArrayList<>();
    for (int index = 0; index < val.length; index++) {
      arr.add(new Element(wt[index], val[index]));
    }
    Collections.sort(arr, (a, b) -> Double.compare(b.valPerKg, a.valPerKg));
    int currBagIndex = 0;
    double result = 0;
    while (currBagIndex < arr.size() && cap > 0) {
      Element currBag = arr.get(currBagIndex);
      long toBeFilled = (long) Math.min(cap, currBag.wt);
      result += (toBeFilled * currBag.valPerKg);
      cap -= (long) toBeFilled;
      currBagIndex++;
    }
    return result;
  }
}

class Element {
  int wt;
  int val;
  double valPerKg;

  Element(int wt, int val) {
    this.wt = wt;
    this.val = val;
    this.valPerKg = (double) val / wt;
  }
}