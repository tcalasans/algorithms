/**
 *  Calculates length of the longest common subsequence
 * 
 * 
 */


import java.util.*;


public class LCS {

    public static int RECURSIVE = 1;
    public static int ITERATIVE_DP = 2;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Use proper Syntax ./program_name <string1> <string2>");
            return;
        }

        String s1 = args[0];
        String s2 = args[1];

        LCS solver = new LCS();

        

        System.out.println("Iterative, Dynamic Programming solution: " + solver.getLCS(s1, s2, ITERATIVE_DP));
        System.out.println("Recursive Solution with Memoization: " + solver.getLCS(s1, s2, RECURSIVE));
        

    }


    
    public int getLCS(String s1, String s2, int mode) {
        if (s1 == null || s2 == null)
            return 0;

        if (mode == ITERATIVE_DP)
            return evalLCSIterative(s1, s2);

        int[][] memo = new int[s1.length()][s2.length()];

        for (int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], -1);

        return getLCSRecHelper(s1, s2, s1.length() -1, s2.length() -1, memo);
    }

    private int getLCSRecHelper(String s1, String s2, int i, int j, int[][]memo) {
        if (i == -1 || j == -1)
            return 0;
        
        if(memo[i][j] != -1)
            return memo[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return (memo[i][j] = 1 + getLCSRecHelper(s1, s2, i - 1, j - 1, memo));

        return (memo[i][j] = Math.max(
            getLCSRecHelper(s1, s2, i, j - 1, memo),
            getLCSRecHelper(s1, s2, i - 1, j, memo)));
    }

    private int evalLCSIterative(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // initialize table
        for (int i = 0; i < s1.length(); i++)
            dp[i][0] = 0;     

        for (int j = 0; j < s2.length(); j++)
            dp[0][j] = 0;

        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j < dp[0].length; j++)
                dp[i][j] = (s1.charAt(i-1) == s2.charAt(j-1)) ? 
                            dp[i-1][j-1] + 1 : 
                            Math.max(dp[i-1][j], dp[i][j-1]);

        return dp[dp.length - 1][dp[0].length - 1];
    }


    

}