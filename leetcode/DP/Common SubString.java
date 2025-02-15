import java.util.*;

public class Main {
    static boolean boundaryChecker(int R, int C, int currR, int currC){
      return (currR >= 0 && currR < R && currC >= 0 && currC < C);
    }
    
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s1 = sc.nextLine();
      String s2 = sc.nextLine();
      int R = s1.length(), C = s2.length();
      int dp[][] = new int[R][C];
      int result = 0;
      
      for(int i = 0; i < R ; i++){
        for(int j = 0 ; j < C ; j++){
          int prevValue = (boundaryChecker(R, C, i-1, j-1)) ? dp[i-1][j-1] : 0;
          if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = prevValue + 1;
          }
          result = Math.max(dp[i][j], result);
        }
      }
      
      for(int i = 0 ; i < R ; i++){
        for(int j = 0 ; j < C ; j++){
          System.out.printf("%d ",dp[i][j]);
        }
        System.out.println();
      }
      System.out.println("Longest String "+ result);
  }
}