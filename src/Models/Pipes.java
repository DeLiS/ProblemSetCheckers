package Models;

import java.util.Scanner;

/**
 * Created by Denis on 12.03.14.
 */
public class Pipes {
    public int getAnswer() {
        return answer;
    }

    private int answer;

    public Pipes(Scanner input){
        int n = input.nextInt();
        Graph graph = new Graph(n);
        int k = input.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                int w = input.nextInt();
                if(w == 0){
                    w = k + 1;
                }
                matrix[i][j] = matrix[j][i] = w;

            }
        }

        Kruskal kruskal = new Kruskal(matrix);
        Edge[] mst = kruskal.getMinimumSpanningTreeEdges();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < mst.length; ++i){
            int w =  mst[i].getWeight();
            if(w > max){
                max = w;
            }
        }

        if(max > k){
            answer = -1;
        }else{
            answer = max;
        }
    }
}
