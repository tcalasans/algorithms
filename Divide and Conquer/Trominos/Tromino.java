/**
 * Algorithm learned on Arup Guha's Computer Science 2 class
 * 
 *
 *
 **/

import java.util.*;



public class Tromino {
    public static final int HOLE = Integer.MIN_VALUE;
    public static final int EMPTY = 0;

    public static void main() {
        Scanner in = new Scanner(System.in);
        
        // dimension of grid -- it has to be a power of two
        System.out.println("Input the size of the grid");
        int n = in.nextInt();

        System.out.println("Input the position of the hole");
        // hole position, o-indexed
        int holeX = in.nextInt();
        int holeY = in.nextInt();

        int[][] grid = new int[n][n];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = (i == holeX && j == holeY) ? HOLE: EMPTY;
            }
        }

        in.close();
    }

    public static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void tileGrid(int[][] grid) {
        tileGrid(grid, grid.length, 0, 0, 1);
    }

    public static void tileGrid(int[][] grid, int size, int topX, int topY, int currentNum) {
        if (size == 2) {
            for (int i = 0; i < size; i++) 
                for (int j = 0; j < size; j++) {
                    if (grid[topX + i][topY + j] == 0)
                        grid[topX + i][topY + j] = currentNum;
                }
            
            currentNum++;
        }
        else {
            
        }



    }
}