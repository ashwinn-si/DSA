class Solution {

    static boolean helper(int num, int currPointer, ArrayList<Integer> arr,int target, int partitionIndex){
       if (currPointer == -1) { // Base case: all digits processed
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum += arr.get(i);
            }
            if (sum == target) {
                return true;
            }
            return false;
        }
      int digit = (num / (int) (Math.pow(10, currPointer))) % 10;
      //we are including it in the ArrayList
      
      int currNum = arr.get(partitionIndex);
      
       arr.set(partitionIndex, (arr.get(partitionIndex) * 10 + digit));
      
      if(helper(num, currPointer-1, arr, target, partitionIndex)){
        return true;
      }
      
      arr.set(partitionIndex, currNum);
      arr.add(digit);
      
      if (helper(num, currPointer - 1, arr, target, partitionIndex + 1)) {
          return true;
      }

      arr.remove(arr.size() - 1);
      return false;
      
    }

    public int punishmentNumber(int n) {
        int sum = 0;
        for(int currNum = 1, result = 0 ; currNum <= n ; currNum++){
            if(helper((int)(currNum*currNum), (int)(Math.log10(currNum*currNum)+1), new ArrayList<Integer>(Arrays.asList(0)), currNum, 0))
            sum += currNum*currNum;
        }
        return sum;
    }
}