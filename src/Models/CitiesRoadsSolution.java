package Models;

import java.util.Scanner;

/**
 * Created by Denis on 12.03.14.
 */
public class CitiesRoadsSolution {
    private Graph graph;
    private int numberOfVertexes;
    private int firstNotReachable = 0;
    public CitiesRoadsSolution(Scanner input){
        int n,m;
        n = input.nextInt();
        numberOfVertexes = n;
        m = input.nextInt();
        graph = new Graph(n);
        for(int i = 0; i < m; ++i){
            int a,b;
            a = input.nextInt();
            b = input.nextInt();
            graph.connect(a, b);
            graph.connect(b, a);
        }
    }

    public CitiesRoadsSolution(Graph g){
        this.graph = g;
        numberOfVertexes = g.getNumberOfVertexes();
    }

    public int solve(){
        int roadsCount = 0;
        boolean[] used = new boolean[numberOfVertexes];

        boolean allConnected = false;
        while(!allConnected){
            BreadthFirstSearch bfs = new BreadthFirstSearch(graph, firstNotReachable);
            bfs.run();
            allConnected = checkConnection(used, bfs);
            if(!allConnected){
                ++roadsCount;
            }
        }
        return roadsCount;

    }

    private boolean checkConnection(boolean[] visitedSomeDay, BreadthFirstSearch bfs) {
        boolean allConnected;
        allConnected = true;
        for(int i = 0; i < numberOfVertexes; ++i){
            boolean visitedThisTime = bfs.visited(i);
            visitedSomeDay[i] = visitedSomeDay[i] || visitedThisTime;
            if(!visitedSomeDay[i] && allConnected){
                allConnected = false;
                firstNotReachable = i;
            }
        }
        return allConnected;
    }
}
