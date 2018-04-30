import java.util.*;




class floyd {
    
    private int[][] adj;
    private int[][] dp;


    public static void main(String[] args) {



    }
    public  floyd(int numNodes) {
        adj = new int[numNodes][numNodes];
        
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                adj[i][j] = (i==j) ? 0 : Integer.MAX_VALUE;
            }
        }

        dp = null;
    }

    public void addEdge(int v1, int v2, int weight) {
        adj[v1][v2] = weight;
        dp = null;
    }


    public void calc() {
        if (dp != null) return;


        dp = new int[adj.length][adj.length];
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                adj[i][j] = (i==j) ? 0 : Integer.MAX_VALUE;
            }
        }


        for (int k = 0; k < adj.length; k++) {
            for (int i = 0; i < adj.length; i++) {
                for (int j = 0; j < adj.length; j++) {
                    if (dp[i][j] > dp[i][k] + dp[k][j])
                        dp[i][j] = dp[i][k] + dp[k][j];
                }
            }
        }
    }

    public void printResult() {        
        System.out.print("  ");

        for (int i = 0; i < adj.length; i++)
            System.out.print(i + " | ");

        System.out.println();


        for (int i = 0; i < adj.length; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < adj.length; j++) {
                System.out.print(dp[i][j]);
            }
        }
    }

    
}
  