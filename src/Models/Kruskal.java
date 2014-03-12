package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Denis on 12.03.14.
 */
public class Kruskal {

    private PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();

    public Edge[] getMinimumSpanningTreeEdges() {
        return minimumSpanningTreeEdges.toArray(new Edge[]{});
    }

    private List<Edge> minimumSpanningTreeEdges;
    private DisjointSetUnion disjointSetUnion;
    private int edgesUsed = 0;
    private int vertixesCount;

    public Kruskal(int[][] matrix){
        initVariables(matrix);
        initQueue(matrix);
        findMinimumSpanningTree();
    }

    private void initVariables(int[][] matrix) {
        vertixesCount = matrix.length;
        disjointSetUnion = new DisjointSetUnion(vertixesCount);
        minimumSpanningTreeEdges = new ArrayList<Edge>(vertixesCount - 1);
    }

    private void findMinimumSpanningTree() {
        while(edgesUsed < vertixesCount - 1){
            Edge nextEdge = priorityQueue.poll();
            if(!disjointSetUnion.areInTheSameSet(nextEdge.getStart(), nextEdge.getEnd())){
                edgesUsed++;
                minimumSpanningTreeEdges.add(nextEdge);
                disjointSetUnion.uniteSetsOf(nextEdge.getStart(), nextEdge.getEnd());
            }
        }
    }

    private void initQueue(int[][] matrix) {
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[i].length; ++j){
                Edge e = new Edge(i, j, matrix[i][j]);
                priorityQueue.add(e);
            }
        }
    }
}
