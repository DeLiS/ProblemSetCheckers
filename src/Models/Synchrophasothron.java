package Models;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Denis on 12.03.14.
 */
public class Synchrophasothron {
    public boolean isPossible() {
        return answer;
    }

    private boolean answer;
    public Synchrophasothron(Scanner input){
        int k = input.nextInt();
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] matrix = new int[n][n];
        for(int[] arr : matrix){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        for(int i = 0; i < m; ++i){
            int a = input.nextInt();
            int b = input.nextInt();
            int p = input.nextInt();
            matrix[a][b] = matrix[b][a] = p;
        }

        Kruskal kruskal = new Kruskal(matrix);
        Edge[] mst = kruskal.getMinimumSpanningTreeEdges();
        long product = 1;
        for(int i = 0;i < mst.length; ++i){
            if(mst[i].getWeight() == Integer.MAX_VALUE){
                answer = false;
            }
            product *= mst[i].getWeight();
        }

        if(product > k){
            answer = false;
        }else{
            answer = true;
        }
    }
}
