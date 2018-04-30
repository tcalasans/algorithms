/**
 * Number of ways to make a change for a certain amount of cents, given that
 * the available coins are: 1, 5, 10, 25
 */


import java.util.*;

public class change {

    public static void main(String[] args) {
        
        if (args.length != 1) {
            System.out.println("Use proper syntax: ./program_name <integer>");
            return;
        }

        int n = new Integer(args[0]).intValue();
        System.out.format("Ways to change for %d using only 1, 5, 10, 25 coins: %d", d, numWaysToChange(n, 25));

    }



    public static int numWaysToChange(int n, int lastCoin) {
        if (d < 0)
            return 0;
        
        if (d == 0)
            return 1;

        int count = 0;
        switch (lastCoin) {
            case 25:
                count += numWaysToChange(n-25, 25);
            case 10:
                count += numWaysToChange(n-10, 10);
            case 5:
                count += numWaysToChange(n-5, 5);
            case 1:
                count++;

        }
        return count;
    }
}