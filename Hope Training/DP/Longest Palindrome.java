import java.util.*;

public class sample {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str1 = "AABBAA"; // original string
    String str2 = "CAABBAA"; //reversing the original string
    int len1 = str1.length();
    int len2 = str2.length();
    int res = 0;
    int dp[][] = new int[len1 + 1][len2 + 1];
    for (int i = 0; i < len1; i++) {
      for (int j = 0; j < len2; j++) {
        if (str1.charAt(i) == str2.charAt(j)) {
          dp[i + 1][j + 1] = dp[i][j] + 1;
          res = Math.max(res, dp[i + 1][j + 1]);
        }
      }
    }
    System.out.println(res);
  }
}