package Models;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Denis on 12.03.14.
 */
public class Tunnels {
    public long getAnswer() {
        return answer;
    }

    private long answer = 0;
    public Tunnels(Scanner input){
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] matrix = new int[n][n];
        for(int[] arr : matrix){
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        for(int i = 0; i < m; ++i){
            int start = input.nextInt();
            int end = input.nextInt();
            int diameter = input.nextInt();
            matrix[start][end] = matrix[end][start] = - diameter;
        }
        Kruskal kruskal = new Kruskal(matrix);
        Edge[] mst = kruskal.getMinimumSpanningTreeEdges();
        for(Edge e : mst){
            if(e.getWeight() == Integer.MIN_VALUE){
                answer = Integer.MIN_VALUE;
                return;
            }
            answer += (- e.getWeight());
        }
    }
}
